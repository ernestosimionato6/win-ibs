package sdn.piano.ibs.commons.jdbc.connectionpool.impl;

import java.util.*;
import java.sql.*;  // Connection, DriverManager, SQLException

import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.ssg.jdbc.model.*; // SSGUsrCredentials

import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


@Slf4j 
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SSGAuthenticatedConnectionPoolImpl implements IBSConnectionPool {

public static List<Integer> TERMINALES;
public static final int INITIAL_POOL_SIZE = 4;
public static final int MAX_POOL_SIZE = 10;
public static final int MAX_TIMEOUT = 60;

public String url;
public String user;
public String password;
SSGUsrCredentials  ibsUsrTpl;
@Builder.Default
public List<IBSConnection> connectionPool = Collections.synchronizedList(new ArrayList<IBSConnection>());
@Builder.Default
public List<IBSConnection> usedConnections = Collections.synchronizedList(new ArrayList<IBSConnection>());
@Builder.Default
public List<Integer> terminalesLibres = Collections.synchronizedList(new ArrayList<Integer>());
@Builder.Default
public List<Integer> terminalesOperativas = Collections.synchronizedList(new ArrayList<Integer>());

@Builder.Default
public Integer maxPoolSize = MAX_POOL_SIZE;

@Override
public Connection getConnection() throws SQLException {
 log.debug(" IBS_POOL | used_connections: {}, free_connections: {}", usedConnections.size(), connectionPool.size());
 Iterator<Integer> terminalesOperativasIterator = terminalesOperativas.iterator();
 if (connectionPool.isEmpty()) {
   if (usedConnections.size() < maxPoolSize) {
        Integer availableTerminal = terminalesLibres.remove(terminalesLibres.size() - 1);
	connectionPool.add(createConnection(url, user, password, ibsUsrTpl.withTercod(availableTerminal)));
//	terminalesOperativas.add(availableTerminal);
   } else {
        throw new RuntimeException("Maximum pool size reached, no available connections!");
   }
 }
 IBSConnection connection = connectionPool.remove(connectionPool.size() - 1);
 if (!connection.isValid(MAX_TIMEOUT)) {
   // @TODO evaluar si no deberia reforzar el cierre de la conexion ibs. // 
   connection = createConnection(url, user, password, connection.ibsUsr);
 }

 usedConnections.add(connection);
 return connection.getSQLConnection();
}

public boolean releaseConnection(Connection connection) {
  log.debug("ibs_pool | release connection {}", connection); 
  Optional<IBSConnection> ibsConn = usedConnections.stream().parallel()
	.filter(iconn -> iconn.getSQLConnection().equals(connection))
	.findAny();
  if(!ibsConn.isPresent()) throw new RuntimeException("Connection not used " + connection);
  connectionPool.add(ibsConn.get());
  return usedConnections.remove(ibsConn.get());
}

public void shutdown() throws SQLException {
  // usedConnections.forEach(this::releaseConnection);
  for (IBSConnection c : usedConnections) {
    c.close();
  }

  for (IBSConnection c : connectionPool) {
    c.close();
  }
  connectionPool.clear();
}

public int getSize() { return connectionPool.size() + usedConnections.size(); }

public static IBSConnectionPool create(String url, String user, String password) throws SQLException {
  return create(url, user, password, SSGUsrCredentials.DEFAULT);
}

public static IBSConnectionPool create(String url, String user, String password, SSGUsrCredentials ibsUsrTpl, List<Integer> terminales, int initialPoolSize) throws SQLException {

  List<IBSConnection> pool = new ArrayList<IBSConnection>(INITIAL_POOL_SIZE);
  for (int i = 0; i < initialPoolSize; i++) {
     pool.add(createConnection(url, user, password, ibsUsrTpl.withTercod(terminales.get(i))));
  }
  SSGAuthenticatedConnectionPoolImpl instace = SSGAuthenticatedConnectionPoolImpl.builder()
	.url(url)
	.user(user)
	.password(password)
	.ibsUsrTpl(ibsUsrTpl)
	.connectionPool(pool)
	.terminalesOperativas(terminales.subList(0, initialPoolSize-1))
	.terminalesLibres(terminales.subList(initialPoolSize, terminales.size()))
	.build();
  instace.maxPoolSize = terminales.size();
  return instace;
}



public static IBSConnectionPool create(String url, String user, String password, SSGUsrCredentials ibsUsrTpl) throws SQLException {

  List<IBSConnection> pool = new ArrayList<IBSConnection>(INITIAL_POOL_SIZE);
  for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
     pool.add(createConnection(url, user, password, ibsUsrTpl.withTercod(TERMINALES.get(i))));
  }
  SSGAuthenticatedConnectionPoolImpl instace =  SSGAuthenticatedConnectionPoolImpl.builder()
	.url(url)
	.user(user)
	.password(password)
	.ibsUsrTpl(ibsUsrTpl)
	.connectionPool(pool)
	.terminalesOperativas(TERMINALES.subList(0, INITIAL_POOL_SIZE-1))
	.terminalesLibres(TERMINALES.subList(INITIAL_POOL_SIZE, TERMINALES.size()))
	.build();
  return instace;
}

private static IBSConnection createConnection(String url, String user, String password, SSGUsrCredentials ibsUsr) throws SQLException {
  log.trace("jdbc::get_connection with \n\t - url: {} \n\t - urs: {} \n\t - password: {} \n\t - ibs_usr: {}",
	 url, user, password, ibsUsr
  ); 
  IBSConnection ibsConn = new IBSConnection(DriverManager.getConnection(url, user, password), ibsUsr);
  return ibsConn;
}


static {

 try {
   DriverManager.registerDriver(new com.sybase.jdbc4.jdbc.SybDriver());
 } catch (Exception e) {
   throw new RuntimeException(e);
 }

 TERMINALES = new ArrayList<Integer>();
 TERMINALES.add(17680);
 TERMINALES.add(17681);
 TERMINALES.add(17682);
 TERMINALES.add(17683);
 TERMINALES.add(17684);
 TERMINALES.add(17685);
 TERMINALES.add(17686);
 TERMINALES.add(17687);
 TERMINALES.add(17688);
 TERMINALES.add(17689);
 TERMINALES.add(17690);
 TERMINALES.add(17691);
 TERMINALES.add(17692);
 TERMINALES.add(17693);
 TERMINALES.add(17694);
 TERMINALES.add(17695);
}

} 
