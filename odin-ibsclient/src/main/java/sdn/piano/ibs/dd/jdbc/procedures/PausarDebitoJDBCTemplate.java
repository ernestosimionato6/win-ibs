package sdn.piano.ibs.dd.jdbc.procedures;

import java.util.*;
import java.math.*;

import java.sql.*;
import javax.sql.*;
// import org.springframework.jdbc.core.*;
// import org.springframework.jdbc.core.simple.*;


public class PausarDebitoJDBCTemplate {

public static final String SP_SDN_STOPDEBIT_WRAPPER = "stopDebitSDNWrapper";
public Connection con;
public String sp;

public PausarDebitoJDBCTemplate(Connection connection, String sp) throws Exception {
  this.con = connection;
 // this.sp = sp;
   this.sp = SP_SDN_STOPDEBIT_WRAPPER;
}

public void execute(String idAdhesion) throws Exception {
  final String SQL_CALL = "{ ? = call "+ sp + "(?, ?, ?, ?) }";
  CallableStatement pstmt = null;
  ResultSet rs = null;
  
  try {
    Connection conn = con;
    pstmt = conn.prepareCall(SQL_CALL);
    pstmt.registerOutParameter(1, Types.INTEGER); 
    pstmt.setLong(2, new Long(idAdhesion)); 
    pstmt.registerOutParameter(3, Types.VARCHAR);
    pstmt.registerOutParameter(4, Types.VARCHAR);
    pstmt.registerOutParameter(5, Types.VARCHAR);

    rs = pstmt.executeQuery(); // execute()
    System.out.println(rs);
    System.out.println(pstmt.getInt(1));
    System.out.println(pstmt.getString(3));
    System.out.println(pstmt.getString(4));
    System.out.println(pstmt.getString(5));
  } catch (SQLException ex) {
    System.out.println("Failed to call statement. " + SQL_CALL);
    System.out.println(ex);
    System.out.println("message: "+ ex.getMessage() + "\n code: " + ex.getErrorCode() +
	"\n state: " + ex.getSQLState());
    throw ex;
  } finally {
    pstmt.close();
  }

}

}
