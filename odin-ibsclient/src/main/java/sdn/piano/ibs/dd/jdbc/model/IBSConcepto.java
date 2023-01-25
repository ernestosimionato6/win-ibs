package sdn.piano.ibs.dd.jdbc.model;

import java.util.stream.Stream;

public enum IBSConcepto {
  ALQ("ALQ"),
  CUO("CUO"),
  EXP("EXP"),
  FAC("FAC"),
  PRE("PRE"),
  SEG("SEG"),
  VAR("VAR");

  public static Stream stream;
  static {
	stream = Stream.of(values());
  }

  public String code; 

  IBSConcepto(String code) {
	this.code = code;
  }

  public static IBSConcepto valueOfCode(String code) {
	return Stream.of(values()).parallel().filter(c -> c.code.equals(code))
		.findAny()
		.orElseThrow(() -> new RuntimeException("Value not found " + code));
  }
}
