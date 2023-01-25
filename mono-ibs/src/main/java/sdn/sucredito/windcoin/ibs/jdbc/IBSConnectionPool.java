package sdn.sucredito.windcoin.ibs.jdbc;

import java.util.*; 	// List
import java.sql.*; 	// Connection, SQLException;


public interface IBSConnectionPool { // extends DataSource {

  IBSConnection getIBSConnection() throws SQLException;
//  Connection getConnection() throws SQLException;
//
//  boolean releaseConnection(Connection connection);
//
//  // List<IBSConnection> getConnectionPool();
//
//  // int getSize();
//
//  void shutdown() throws SQLException;
//
//  String getUrl();
//  String getUser();
//  String getPassword();

  Connection getConnection() throws SQLException;

  boolean releaseConnection(Connection connection);

  List<Connection> getConnectionPool();

  int getSize();

  String getUrl();

  String getUser();

  String getPassword();

  void shutdown() throws SQLException;;
}
