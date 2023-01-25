package sdn.sucredito.windcoin.ibs.jdbc;

import org.postgresql.jdbc2.optional.SimpleDataSource;

import java.sql.Connection;
import java.sql.SQLException;



public class MonoDataSource extends SimpleDataSource {

public IBSConnectionTerminalBased ibsConn;

public MonoDataSource(IBSConnectionTerminalBased ibsConn) {
this.ibsConn = ibsConn;
}

@Override 
public Connection getConnection() throws SQLException {
  System.out.println("ibs_mono_datasource -> getConnection ");
  System.out.println(" ................................................................................... ");
  System.out.println(" [DEBUG] ibs_connection : " + ibsConn);
  return ibsConn.getSQLConnection();
}

public void releaseConnection(Connection con) {
  System.out.println("ibs_mono_datasource -> release_connection ");
  ibsConn.releaseConnection(con);
}


}
