package sdn.piano.ibs.dd.service;

import sdn.piano.ibs.dd.domain.*;

import java.util.*;

public interface IBSDDQueryService {

public List<DebitoAdherido> obtenerDebitosAdheridos(
	String tipoCuenta,
	String nroCuenta
) throws Exception;

public List<DebitoRealizado> obtenerDebitosRealizados(
	String tipoCuenta,
	String nroCuenta
) throws Exception;

}
