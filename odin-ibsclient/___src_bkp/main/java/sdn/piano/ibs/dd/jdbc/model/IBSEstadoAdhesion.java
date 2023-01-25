package sdn.piano.ibs.dd.jdbc.model;

import java.util.stream.*;

public enum IBSEstadoAdhesion {
  VIGENTE("VIGENTE");

  public String code;

  IBSEstadoAdhesion(String code) {
	this.code = code;
  }

  public static IBSEstadoAdhesion valueOfCode(String code) {
	return Stream.of(values()).parallel().filter(e -> e.code.equals(code))
		.findAny()
		.orElseThrow(() -> new RuntimeException("Value not found " + code));
  }
  
}
