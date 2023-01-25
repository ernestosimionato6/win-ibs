package sdn.piano.ibs.dd.jdbc.model;

import java.util.*;
import java.util.stream.*;

public enum IBSMonCod {
  PESOS("032"),
  DOLARES("840");

  public String code;

  IBSMonCod(String code) {
	this.code = code;
  }

  public static IBSMonCod valueOfCode(String code) {
    return Stream.of(values()).parallel().filter(c -> c.code.equals(code))
	.findAny()
	.orElseThrow(() -> new RuntimeException("Value not found " + code));
  } 
}
