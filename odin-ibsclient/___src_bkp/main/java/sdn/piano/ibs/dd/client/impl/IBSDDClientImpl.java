package sdn.piano.ibs.dd.client.impl;

import sdn.piano.ibs.dd.service.*;
import sdn.piano.ibs.dd.domain.*;

import sdn.piano.ibs.dd.client.metrics.*;
import sdn.piano.ibs.dd.client.request.*;
import sdn.piano.ibs.dd.client.response.*;
import sdn.piano.ibs.dd.client.config.*;
import sdn.piano.ibs.dd.client.*;
import sdn.piano.ibs.dd.repository.*;
import sdn.piano.ibs.dd.repository.impl.*;
import sdn.piano.ibs.dd.service.*;
import sdn.piano.ibs.dd.service.impl.*;

import sdn.piano.ibs.ssg.jdbc.model.SSGUsrCredentials;

import sdn.piano.ibs.commons.*;
import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.commons.jdbc.connectionpool.impl.*;


import lombok.extern.slf4j.Slf4j;

import java.util.*;

import static sdn.piano.ibs.commons.jdbc.IBSJDBCUtils.*;
import static sdn.util.SdnObjectMapperReflection.convert;
import static sdn.lang.text.TextTable.render;


@Slf4j
public class IBSDDClientImpl implements IBSDDClient {

public IBSDDClientMetrics metrics;

public IBSDDClientConfig config;
public IBSConnectionPool pool;
public IBSDDQueryService querySrv;
public IBSDDManaService manaSrv;
public IBSDebitosAdheridosRepository debitosAdheridosRepository;
public IBSDebitosRealizadosRepository debitosRealizadosRepository;

public IBSDDClientImpl(IBSDDClientConfig config) throws Exception {
this.config = config;
this.pool = this.createPool(config); 
this.debitosAdheridosRepository = new IBSDebitosAdheridosRepositoryImpl(pool);
this.debitosRealizadosRepository = new IBSDebitosRealizadosRepositoryImpl(pool);
this.metrics = new IBSDDClientMetrics();
IBSDDHydraService service = new IBSDDServiceImpl(
	debitosAdheridosRepository,
	debitosRealizadosRepository
);
this.querySrv = service; 
this.manaSrv = service;
}

public IBSDDObtenerDebitosAdheridosResponse obtenerDebitosAdheridos(IBSDDObtenerDebitosAdheridosRequest request)
   throws Exception {
   metrics.hit();

   List<DebitoAdherido> debitosAdheridos = null;
   try { 
	debitosAdheridos = querySrv.obtenerDebitosAdheridos(request.tipoCuenta, request.nroCuenta);
	log.debug(" isb_dd_client debitos adheridos encontrados para la cuenta {}  son: \n {}", 
		request,
		render("debito_adherido", debitosAdheridos));
   	return IBSDDObtenerDebitosAdheridosResponse.builder()
	.debitosAdheridos(debitosAdheridos)
	.build();
   } catch (Exception e) {
	log.error(" ibs_dd_client error al consultar adheridos of {} -> {}",
		request, e
 	);
	metrics.internalError();
	throw e;
   } 
}

public IBSDDObtenerDebitosRealizadosResponse obtenerDebitosRealizados(IBSDDObtenerDebitosRealizadosRequest request)
   throws Exception {

  List<DebitoRealizado> debitosRealizados = null;
  try {
	debitosRealizados = querySrv.obtenerDebitosRealizados(request.tipoCuenta, request.nroCuenta);
  return IBSDDObtenerDebitosRealizadosResponse.builder()
	.debitosRealizados(debitosRealizados)
	.build();
  } catch (Exception e) {
	log.error(" ibs_dd_client error al consultar realizados of {} -> {}",
		request, e
 	);
	metrics.internalError();
	throw e;
  }
}

public IBSDDPausarDebitoAdheridoResponse pausarDebitoAdherido(IBSDDPausarDebitoAdheridoRequest request) throws Exception {
  System.out.println("@TODO ........................... pausar debito adherido . ");
  Tramite tramite = null;
  try {
	tramite = manaSrv.pausarDebitoAdherido(request.idAdhesion); 
  } catch (Exception e) {
	log.error(" ibs_dd_client error al pausar adhesion of {} -> {}",
		request, e
	);
	metrics.internalError();
	throw e;
  }
  return IBSDDPausarDebitoAdheridoResponse.builder().tramite(tramite).build();
}


public IBSDDBajarDebitoAdheridoResponse bajarDebitoAdherido(IBSDDBajarDebitoAdheridoRequest request) throws Exception {
  System.out.println("@TODO ........................... bajar debito adherido . ");
  Tramite tramite = null;
  try {
	tramite = manaSrv.bajarDebitoAdherido(request.idAdhesion); 
  } catch (Exception e) {
	log.error(" ibs_dd_client error al bajar adhesion of {} -> {}",
		request, e
	);
	metrics.internalError();
	throw e;
  }
  return IBSDDBajarDebitoAdheridoResponse.builder().tramite(tramite).build();
}


public IBSDDReanudarDebitoAdheridoResponse reanudarDebitoAdherido(IBSDDReanudarDebitoAdheridoRequest request) throws Exception {
  System.out.println("@TODO ........................... reanudar debito adherido . ");
  Tramite tramite = null;
  try {
	tramite = manaSrv.reanudarDebitoAdherido(request.idAdhesion); 
  } catch (Exception e) {
	log.error(" ibs_dd_client error al reanudar adhesion of {} -> {}",
		request, e
	);
	metrics.internalError();
	throw e;
  }
  return IBSDDReanudarDebitoAdheridoResponse.builder().tramite(tramite).build();
}


public IBSDDReversarDebitoRealizadoResponse reversarDebitoRealizado(IBSDDReversarDebitoRealizadoRequest request) throws Exception {
  System.out.println("@TODO ........................... reversar debito realizado . ");
  Tramite tramite = null;
  try {
	tramite = manaSrv.reversarDebitoRealizado(request.id); 
  } catch (Exception e) {
	log.error(" ibs_dd_client error al reversar realizado of {} -> {}",
		request, e
	);
	metrics.internalError();
	throw e;
  }
  return IBSDDReversarDebitoRealizadoResponse.builder().tramite(tramite).build();
}





public IBSConnectionPool  createPool(IBSDDClientConfig config) throws Exception {
   log.trace("starting connections...");
   pool = SSGAuthenticatedConnectionPoolImpl.create(
	jdbcUrl(config.host, config.port, config.database),
        config.username , 
	config.password,
	SSGUsrCredentials.builder()
	.entidadcodpar(config.entidadcodpar)
	.entidadpasswpar(config.entidadpasswpar)
	.paiscod(config.paiscod)
	.bcocod(config.bcocod)
	.succod(config.succod)
	.tipdoc(config.tipdoc)
	.usrident(config.usrident)
        .tercod(config.tercod)
	.origpaiscod(config.origpaiscod)
	.origbcocod(config.origbcocod)
	.origsuccod(config.origsuccod)
	.concepto(config.concepto)
	.tipoPrint(config.tipoPrint)
	.build(),
	config.terminales,
	config.initialPoolSize 
   );	
   log.trace("pool created."); 
   return pool;
} 

@Override
public String toString() {
 try {
 return "IBSDDClient: \n " + render("IBSDDCLIENT_METRICS", convert(metrics))
	+ " \n " + render("IBSDDCONFIG", convert(config));
 } catch( Exception e ) {
   throw new RuntimeException(e);
 }
}

}
