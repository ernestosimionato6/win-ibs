package sdn.piano.ibs.dd.service.impl;

import sdn.piano.ibs.dd.service.*;
import sdn.piano.ibs.dd.domain.*;
import sdn.piano.ibs.dd.repository.*;
import java.util.*;

public class IBSDDServiceImpl implements IBSDDHydraService {

public IBSDebitosAdheridosRepository debitosAdheridosRepository;
public IBSDebitosRealizadosRepository debitosRealizadosRepository;

public IBSDDServiceImpl(
  IBSDebitosAdheridosRepository debitosAdheridosRepository,
  IBSDebitosRealizadosRepository debitosRealizadosRepository 
) {
  this.debitosAdheridosRepository = debitosAdheridosRepository;
  this.debitosRealizadosRepository = debitosRealizadosRepository;
}

public List<DebitoAdherido> obtenerDebitosAdheridos(
	String tipoCuenta,
	String nroCuenta
) throws Exception {
	return debitosAdheridosRepository.obtenerDebitosAdheridos(
		tipoCuenta,
		nroCuenta
	);
}

public List<DebitoRealizado> obtenerDebitosRealizados(
	String tipoCuenta,
	String nroCuenta
) throws Exception {
	return debitosRealizadosRepository.obtenerDebitosRealizados(
		tipoCuenta,
		nroCuenta
	);
}

public Tramite pausarDebitoAdherido(
  String idAdhesion
) throws Exception {
     return debitosAdheridosRepository.pausarDebitoAdherido(
	idAdhesion
     );
}

public Tramite bajarDebitoAdherido(
  String idAdhesion
) throws Exception {
     return debitosAdheridosRepository.bajarDebitoAdherido(
	idAdhesion
     );
}

public Tramite reanudarDebitoAdherido(
  String idAdhesion
) throws Exception {
     return debitosAdheridosRepository.reanudarDebitoAdherido(
	idAdhesion
     );
}

public Tramite reversarDebitoRealizado (
  String id
) throws Exception {
  return debitosRealizadosRepository.reversarDebitoRealizado(
	id
  );
}



}
