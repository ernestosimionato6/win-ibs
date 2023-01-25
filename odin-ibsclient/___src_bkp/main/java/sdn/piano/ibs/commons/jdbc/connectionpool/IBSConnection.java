package sdn.piano.ibs.commons.jdbc.connectionpool;

import java.util.*;
import java.sql.*;
import lombok.*;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import sdn.piano.ibs.commons.jdbc.connectionpool.MonoDataSource;
import sdn.piano.ibs.ssg.jdbc.procedure.*;

import sdn.piano.ibs.ssg.jdbc.model.SSGUsrCredentials;

interface IBSConnectionInterface {

public void checkLoginUsr() throws Exception;
public Boolean isValid(int timeout) throws Exception;
public void close() throws Exception;

public Connection getSQLConnection();
public SSGUsrCredentials getUsrCredentials();
}

@Slf4j 
@Data
@ToString
public class IBSConnection implements IBSConnectionInterface { 

  public Connection sqlConnection;
  public SSGUsrCredentials ibsUsr;

  public IBSConnection(Connection sqlConnection, SSGUsrCredentials ibsUsr) throws SQLException {
      log.trace("building ibs_connection with {}",  ibsUsr);
      this.sqlConnection = sqlConnection;
      this.ibsUsr = ibsUsr; 
      checkLoginUsr();
  }

  public void checkLoginUsr() throws SQLException {
     /*  @TODO  Implement call(ssg_check_login_usr) */
     log.debug(" @TODO call(ssg_check_login_usr) with {}", ibsUsr);
     SSGCheckLoginUsr sp = new SSGCheckLoginUsr(
	new MonoDataSource(this)
     );
     try {
     sp.execute(ibsUsr);
     } catch (Exception e) { throw new SQLException(e); }
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
  public SSGUsrCredentials getUsrCredentials() { return ibsUsr; }

  public void releaseConnection(Connection con) {
   System.out.println("[@TODO] ................... ibs_connection :: release_connection" + con);
  }
}

