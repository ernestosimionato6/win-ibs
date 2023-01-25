package sdn.piano.ibs.dd.repository.impl;

import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.commons.jdbc.*;
import sdn.piano.ibs.dd.domain.*;
import sdn.piano.ibs.dd.repository.*;
import sdn.piano.ibs.dd.jdbc.procedures.*;
import sdn.piano.ibs.dd.jdbc.model.*;

import java.util.*;
import java.sql.*;
import javax.sql.*;

public class IBSDebitosAdheridosRepositoryImpl implements IBSDebitosAdheridosRepository {

public   IBSConnectionPool pool;
public   IBSDataSource dataSource;

public IBSDebitosAdheridosRepositoryImpl(
  IBSConnectionPool pool
) {
  this.pool = pool;
  this.dataSource = new IBSDataSource(pool);
}


public List<DebitoAdherido> obtenerDebitosAdheridos(
   String tipoCuenta, String nroCuenta 
) throws Exception {
  ObtenerDebitosAdheridosStoredProcedure sp =
	new ObtenerDebitosAdheridosStoredProcedure(dataSource); 

  List<DebitoAdherido> debitosAdheridos = new ArrayList<DebitoAdherido>(); 

  List<IBSDebitoAdherido> resultset = sp.execute(tipoCuenta, nroCuenta);
  resultset.stream().forEach(r -> {
	debitosAdheridos.add(DebitoAdherido.builder()
		.nroAdhesion(""+r.idnroadhesion)
	 	.codigoEmpresa(""+r.entidadnom)
		.concepto(""+r.concepto)
		.idCliente(""+r.desapenom)
		.moneda(""+r.moncod)
		.fechaAdhesion(""+r.fecadhesion)
		.cuenta(CuentaPBF.of(TipoCuentaPBF.valueOfCode(r.tipoCtaPbf.code), ""+r.ctaPbf))
		.fechaVencimiento(""+r.fechaVencimiento)
		.monto(""+r.monto)
		.estadoAdhesion(""+r.estado)
		.build()
	);
  });

  return debitosAdheridos;
}

public Tramite pausarDebitoAdherido( String idAdhesion ) throws Exception {
  PausarDebitoStoredProcedure sp = new PausarDebitoStoredProcedure(dataSource);

  IBSTramite result = sp.execute(idAdhesion);
  return Tramite.of(result.numeroTramite, result.estadoTramite); 
}

public Tramite bajarDebitoAdherido( String idAdhesion ) throws Exception {
  BajarDebitoAdheridoStoredProcedure sp = new BajarDebitoAdheridoStoredProcedure(dataSource);

  IBSTramite result = sp.execute(idAdhesion);
  return Tramite.of(result.numeroTramite, result.estadoTramite); 
}


public Tramite reanudarDebitoAdherido( String idAdhesion ) throws Exception {
  ReanudarDebitoAdheridoStoredProcedure sp = new ReanudarDebitoAdheridoStoredProcedure(dataSource);

  IBSTramite result = sp.execute(idAdhesion);
  return Tramite.of(result.numeroTramite, result.estadoTramite); 
}


}
