package sdn.piano.ibs.commons.jdbc.connectionpool;

import sdn.piano.ibs.commons.jdbc.*;

import sdn.piano.ibs.commons.jdbc.connectionpool.impl.*;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Logger;



public class MonoDataSource extends SimpleDataSource {

public IBSConnection ibsConn;

public MonoDataSource(IBSConnection ibsConn) {
this.ibsConn = ibsConn;
}

@Override 
public Connection getConnection() throws SQLException {
  System.out.println("ibs_mono_datasource -> getConnection ");
  return ibsConn.getSQLConnection();
}

public void releaseConnection(Connection con) {
  System.out.println("ibs_mono_datasource -> release_connection ");
  ibsConn.releaseConnection(con);
}


}
