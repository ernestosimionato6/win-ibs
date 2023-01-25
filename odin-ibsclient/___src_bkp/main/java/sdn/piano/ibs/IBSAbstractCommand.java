package sdn.piano.ibs;

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
public abstract class IBSAbstractCommand {

public   IBSConnectionPool pool;
public   IBSConnection ibsConnection;
public   Connection sqlConnection;

public void bootstrap() throws Exception {
log.trace(" bootstraping ...................... ");
createPool();     
sqlConnection = pool.getConnection();
// ibsConnection = pool.getConnection();
// sqlConnection = ibsConnection.getSQLConnection();
}

public void down() throws Exception {
   shutdownPool();
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
