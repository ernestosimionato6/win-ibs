package sdn.piano.ibs.dd.jdbc.model;

import java.util.stream.*;

public enum IBSEstadoDebito {

  REALIZADO("REALIZADO");

  public String code;

  IBSEstadoDebito(String code) {
	this.code = code;
  }

  public static IBSEstadoDebito valueOfCode(String code) {
	return Stream.of(values()).parallel().filter(e -> e.code.equals(code))
		.findAny()
		.orElseThrow(() -> new RuntimeException("Value not found " +  code));
  }

}
