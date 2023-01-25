package sdn.piano.ibs.dd.jdbc.procedures;

import java.util.*;
import java.math.*;

import java.sql.*;
import javax.sql.*;


public class SpCallJdbcTemplate {

public Connection con;

public SpCallJdbcTemplate(Connection connection) throws Exception {
  this.con = connection;
}

public void execute(String sql) throws Exception {
  ResultSet rs = null;
  Statement stmt = null; 
  try {
    Connection conn = con;
    stmt = conn.createStatement();
    rs = stmt.executeQuery(sql);
    rs.next();
    System.out.println(rs.getString(1));
  } catch (SQLException ex) {
    System.out.println("Failed to call statement. " + sql);
    System.out.println(ex);
    System.out.println("message: "+ ex.getMessage() + "\n code: " + ex.getErrorCode() +
	"\n state: " + ex.getSQLState());
    throw ex;
  } finally {
    stmt.close();
  }

}

}

