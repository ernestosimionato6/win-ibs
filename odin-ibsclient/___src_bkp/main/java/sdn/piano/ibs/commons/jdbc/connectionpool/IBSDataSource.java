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



public class IBSDataSource extends SimpleDataSource {

public IBSConnectionPool pool;

public IBSDataSource(IBSConnectionPool pool) {
this.pool = pool;
}

@Override 
public Connection getConnection() throws SQLException {
  System.out.println("ibs_datasource -> getConnection ");
  return pool.getConnection();
}

public void releaseConnection(Connection con) {
  System.out.println("ibs_datasource -> release_connection ");
  pool.releaseConnection(con);
}


}
