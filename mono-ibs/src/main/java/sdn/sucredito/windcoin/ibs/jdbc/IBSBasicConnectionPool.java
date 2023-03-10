package sdn.sucredito.windcoin.ibs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;


public class IBSBasicConnectionPool implements IBSConnectionPool {


    static {
        try {
            DriverManager.registerDriver(new com.sybase.jdbc4.jdbc.SybDriver());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private final String url;
    private final String user;
    private final String password;
    private final List<Connection> connectionPool;
    private final List<Connection> usedConnections = new ArrayList<>();
    private static int INITIAL_POOL_SIZE = 2; // 5; // 10; //
    private static int MAX_POOL_SIZE = 10; // 20;
    private static int MAX_TIMEOUT = 5;

    public static IBSBasicConnectionPool create(
            String url,
            String user,
            String password,
            Integer initialPoolSize,
            Integer maxPoolSize,
            Integer maxTimeout
    ) throws SQLException {

        INITIAL_POOL_SIZE = initialPoolSize;
        MAX_POOL_SIZE = maxPoolSize;
        MAX_TIMEOUT = maxTimeout;
        return create(url, user, password);
    }

    public static IBSBasicConnectionPool create(String url, String user, String password) throws SQLException {
        List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            pool.add(createConnection(url, user, password));
        }
        return new IBSBasicConnectionPool(url, user, password, pool);
    }


    public IBSBasicConnectionPool(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = new ArrayList<>();
    }

    private IBSBasicConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
        this.url = url;
        this.user = user;
        this.password = password;
        this.connectionPool = connectionPool;
    }

    @Override
    public IBSConnection getIBSConnection() throws SQLException {
        return new SimpleIBSConnection(
                getConnection()
        );
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (connectionPool.isEmpty()) {
            if (usedConnections.size() < MAX_POOL_SIZE) {
                connectionPool.add(createConnection(url, user, password));
            } else {
                throw new RuntimeException("Maximum pool size reached, no available connections!");
            }
        }

        Connection connection = connectionPool.remove(connectionPool.size() - 1);

        if(!connection.isValid(MAX_TIMEOUT)){
            connection = createConnection(url, user, password);
        }

        usedConnections.add(connection);
        return connection;
    }

    @Override
    public boolean releaseConnection(Connection connection) {
        connectionPool.add(connection);
        return usedConnections.remove(connection);
    }

    private static Connection createConnection(String url, String user, String password) throws SQLException {
        Connection con =  DriverManager.getConnection(url, user, password);
        out.println(" [ ibs-connection-pool ] create_connection of "
                + url + "   " + user + "   " + password + " "
                + con.hashCode() + "   "  + con.getMetaData().getURL() + " | "
                + con.getMetaData().getUserName()
        );
        return con;
    }

    @Override
    public int getSize() {
        return connectionPool.size() + usedConnections.size();
    }

    @Override
    public List<Connection> getConnectionPool() {
        return connectionPool;
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public String getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void shutdown() throws SQLException {
        usedConnections.forEach(this::releaseConnection);
        for (Connection c : connectionPool) {
            out.println(" [ ibs-connection-pool ] closing_connection of "
                    + c.hashCode() + "   "  + c.getMetaData().getURL() + " | "
                    + c.getMetaData().getUserName()
            );
            c.close();
        }
        connectionPool.clear();
    }
}
