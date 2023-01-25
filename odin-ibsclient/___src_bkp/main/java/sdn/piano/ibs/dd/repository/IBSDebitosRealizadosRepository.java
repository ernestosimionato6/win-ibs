package sdn.piano.ibs.dd.repository;

import sdn.piano.ibs.dd.domain.DebitoRealizado;

import sdn.piano.ibs.dd.jdbc.model.*;
import sdn.piano.ibs.dd.domain.*;

import java.util.*;

public interface IBSDebitosRealizadosRepository {

  List<DebitoRealizado> obtenerDebitosRealizados(
	String tipoCuenta,
	String nroCuenta
  ) throws Exception;

  Tramite reversarDebitoRealizado(
	String id
  ) throws Exception;

}
