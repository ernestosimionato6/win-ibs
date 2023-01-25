package sdn.piano.ibs.commons.jdbc.connectionpool.samples;

import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.commons.jdbc.connectionpool.impl.*;
import sdn.piano.ibs.ssg.jdbc.model.SSGUsrCredentials;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class IBSConnUsrSamples {

public static void clone_with_tercod() {

  SSGUsrCredentials original = SSGUsrCredentials.builder()
	.entidadcodpar(1057)
	.entidadpasswpar("PSW CENSYS")
	.paiscod(54)
	.bcocod(301)
	.succod(1)
	.tipdoc(88)
	.usrident(2000001)
        .tercod(17680)
	.origpaiscod(54)
	.origbcocod(301)
	.origsuccod(1)
	.concepto("H2H")
	.tipoPrint(0)
	.build();	
  log.trace("Ibs_conn_usr samples >> clone_with_tercod | original: {} ", original);
	
  SSGUsrCredentials duplicate = original.withTercod(99999);
  log.trace("Ibs_conn_usr samples >> clone_with_tercod | duplicate: {} ", duplicate);

}

}
