package sdn.piano.ibs.commons.jdbc.connectionpool;

import java.util.*; 	// List
import java.sql.*; 	// Connection, SQLException;
import javax.sql.*;

public interface IBSConnectionPool { // extends DataSource {

  // IBSConnection getConnection() throws SQLException;
  Connection getConnection() throws SQLException;

  boolean releaseConnection(Connection connection);

  // List<IBSConnection> getConnectionPool();

  // int getSize();

  void shutdown() throws SQLException;

  // String getUrl();
  // String getUser();
  // String getPassword();


}
