package sdn.piano.ibs.dd.repository;

import sdn.piano.ibs.dd.domain.*;

import java.util.*;

public interface IBSDebitosAdheridosRepository {

  List<DebitoAdherido> obtenerDebitosAdheridos(
	String tipoCuenta,
	String nroCuenta
  ) throws Exception;

  public Tramite pausarDebitoAdherido( String idAdhesion ) throws Exception;
  public Tramite bajarDebitoAdherido( String idAdhesion ) throws Exception;
  public Tramite reanudarDebitoAdherido( String idAdhesion ) throws Exception;

}
