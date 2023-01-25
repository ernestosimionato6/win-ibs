package sdn.piano.ibs.commons.jdbc.connectionpool.samples;

import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.commons.jdbc.connectionpool.impl.*;

import lombok.extern.slf4j.Slf4j;
import sdn.piano.ibs.ssg.jdbc.model.SSGUsrCredentials;

import static sdn.piano.ibs.commons.jdbc.IBSJDBCUtils.*;


@Slf4j
public final class BasicConnectionPoolSamples {


public static void create_pool() throws Exception {
   log.trace("starting connections...");
   IBSConnectionPool pool = SSGAuthenticatedConnectionPoolImpl.create(
	jdbcUrl("172.16.41.23", "4112", "Banksys"),
        "perezr", 
	"apolo11*",
	SSGUsrCredentials.DEFAULT
   );
   log.trace("sleeping ..."); 
   Thread.sleep(15*60);
   log.trace("releasing connections ...");
   pool.shutdown();
   log.trace("sleeping again ...");
   Thread.sleep(15*60);
   log.trace("done... ");
    
}

}
