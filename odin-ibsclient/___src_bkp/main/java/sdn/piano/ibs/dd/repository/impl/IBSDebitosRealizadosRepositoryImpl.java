package sdn.piano.ibs.dd.repository.impl;

import java.util.*;

import sdn.piano.ibs.commons.jdbc.connectionpool.*;
import sdn.piano.ibs.commons.jdbc.*;
import sdn.piano.ibs.dd.domain.*;
import sdn.piano.ibs.dd.repository.*;
import sdn.piano.ibs.dd.jdbc.procedures.*;
import sdn.piano.ibs.dd.jdbc.model.*;


public class IBSDebitosRealizadosRepositoryImpl implements IBSDebitosRealizadosRepository {

public IBSConnectionPool pool;
public IBSDataSource dataSource;

public IBSDebitosRealizadosRepositoryImpl(
  IBSConnectionPool pool
) {
  this.pool = pool;
  this.dataSource = new IBSDataSource(pool);
}

public List<DebitoRealizado> obtenerDebitosRealizados(
   String tipoCuenta,
   String nroCuenta
) throws Exception {
  ObtenerDebitosRealizadosStoredProcedure sp =
	new ObtenerDebitosRealizadosStoredProcedure(dataSource);
  List<DebitoRealizado> debitosRealizados = new ArrayList<DebitoRealizado>();
  List<IBSDebitoRealizado> resultset = sp.execute(tipoCuenta, nroCuenta);
  resultset.stream().forEach(r -> {
	debitosRealizados.add(DebitoRealizado.builder()
		.nroComprobante(""+r.idExtension)
		.codigoEmpresa(""+r.empresa)
		.nombreEmpresa(""+r.empresa)
		.concepto(""+r.concepto)
		.idCliente(""+r.desapenom)
		.moneda(""+r.moncod)
		.fechaVencimiento(""+r.fecaviso)
		.monto(""+r.monto)
		.moneda(""+r.moncod)
		.cuenta(CuentaPBF.of(TipoCuentaPBF.valueOfCode(r.tipoCtaPbf.code), ""+r.ctaPbf))
		.referencia(""+r.referencia)
		.estadoDebito(""+r.estadoDebito)
		.build()
	);
  });
  return debitosRealizados;
}

public Tramite reversarDebitoRealizado( String id ) throws Exception {
  ReversarDebitoRealizadoStoredProcedure sp = new ReversarDebitoRealizadoStoredProcedure(dataSource);
  IBSTramite result = sp.execute(id);
  return Tramite.of(result.numeroTramite, result.estadoTramite);
}

}
