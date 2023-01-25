package sdn.piano.ibs.dd.domain;

public enum EstadoTramite {
 APROBADO,
 RECHAZADO;

public static EstadoTramite startWith(String s) {
  if(s.startsWith(APROBADO.toString())) {
	return APROBADO;
  } else if (s.startsWith(RECHAZADO.toString())) {
	return RECHAZADO;
  }
  throw new RuntimeException("Estado de tramite no Tabulado");
}
}
