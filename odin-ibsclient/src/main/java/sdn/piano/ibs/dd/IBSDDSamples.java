package sdn.piano.ibs.dd;

import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.commons.jdbc.connectionpool.impl.*;
import sdn.piano.ibs.commons.jdbc.connectionpool.samples.*;
import sdn.piano.ibs.ssg.jdbc.model.SSGUsrCredentials;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;

import static sdn.piano.ibs.commons.jdbc.IBSJDBCUtils.*;
import static sdn.piano.ibs.commons.jdbc.connectionpool.samples.BasicConnectionPoolSamples.*;
import static sdn.piano.ibs.commons.jdbc.connectionpool.samples.IBSConnUsrSamples.*;


@Slf4j
public class IBSDDSamples {

   IBSConnectionPool pool;
   IBSConnection ibsConnection;
   Connection sqlConnection;

public static void main(String args[]) throws Exception {
IBSDDSamples ctx = new IBSDDSamples();

ctx.bootstrap();
log.trace(" Sampling [ IBS_DD ] .................. "); // clone_with_tercod(); // create_pool();


String tipoCuenta = "11"; 
String nroCuenta = "01605000016195698";

ctx.obtenerDebitosAdheridos(tipoCuenta, nroCuenta);

ctx.down();
}

public void bootstrap() throws Exception {
log.trace(" bootstraping ...................... ");
createPool();     
// ibsConnection = pool.getConnection();
sqlConnection = ibsConnection.getSQLConnection();
}

public void down() throws Exception {
   shutdownPool();
}

public void obtenerDebitosAdheridos(String tipoCuenta, String nroCuenta) {
  log.trace(" obtener_debitos_adheridos ......................... " + nroCuenta );
  // sqlConnection; 
}

public void createPool() throws Exception {
   log.trace("starting connections...");
   pool = SSGAuthenticatedConnectionPoolImpl.create(
	jdbcUrl("172.16.41.23", "4112", "Banksys"),
        "perezr", 
	"apolo11*",
	SSGUsrCredentials.DEFAULT
   );
   log.trace("pool created."); 
} 

public void shutdownPool() throws Exception {
   pool.shutdown();
   log.trace("pool shutdown");
}

}
