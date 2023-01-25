package sdn.sucredito.windcoin.ibs.jdbc;

import java.sql.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;


import sdn.sucredito.windcoin.ibs.ssg.jdbc.procedures.SSGCheckLoginUsr;

@Slf4j
@Data
@ToString
public class IBSConnectionTerminalBased implements IBSConnection {

  public Connection sqlConnection;
  public SSGUsrCredentials ibsUsr;

  public IBSConnectionTerminalBased(Connection sqlConnection, SSGUsrCredentials ibsUsr) throws SQLException {
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

