package sdn.sucredito.windcoin.ibs.jdbc;

import org.postgresql.jdbc2.optional.SimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;



public class IBSDataSource extends SimpleDataSource {

public IBSConnectionPool pool;

public IBSDataSource(IBSConnectionPool pool) {
this.pool = pool;
}

@Override 
public Connection getConnection() throws SQLException {
  System.out.println("ibs_datasource -> getConnection ");
  IBSConnectionTerminalBased ibsConnection = pool.getIBSConnection();
  System.out.println("[DEBUG]  ibs_connection : " + ibsConnection);
  return ibsConnection.getSQLConnection();
}

public void releaseConnection(Connection con) {
  System.out.println("ibs_datasource -> release_connection ");
  pool.releaseConnection(con);
}


}
