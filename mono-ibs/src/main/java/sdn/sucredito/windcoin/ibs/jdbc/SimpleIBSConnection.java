package sdn.sucredito.windcoin.ibs.jdbc;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;

import java.sql.Connection;
import java.sql.SQLException;


@Slf4j
@Data
@ToString
public class SimpleIBSConnection implements IBSConnection {

    public Connection sqlConnection;

    public SimpleIBSConnection(Connection sqlConnection) throws SQLException {
        log.trace("building ibs_connection with {}",  sqlConnection.getClientInfo());
        this.sqlConnection = sqlConnection;
    }

    public Boolean isValid(int timeout) throws SQLException {
        try {
            return sqlConnection.isValid(timeout);
        } catch (SQLException e) {
            log.error("ibs_connection | error al intentar validar el estado de la conexion a ibs. \n {}", e);
            return false;
        }
    }

    public void close() throws SQLException {
        // @TODO Skipped real closed.
        System.out.println("@TODO skipped real sqlconnection.close()");
        return;
        // sqlConnection.close();
    }


    public Connection getSQLConnection() { return sqlConnection; }

    public void releaseConnection(Connection con) {
        System.out.println("[@TODO] ................... ibs_connection :: release_connection" + con);
    }

}
