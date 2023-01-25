package sdn.piano.ibs.dd.domain;

import java.util.stream.*;

public enum TipoCuentaPBF {

CUENTA_CORRIENTE_PESOS("01"),
CUENTA_CORRIENTE_DOLARES("07"),
CAJA_DE_AHORROS_EN_PESOS("11"),
CAJA_DE_AHORROS_EN_DOLARES("15");

public String code;

TipoCuentaPBF(String code) {
 this.code = code;
}

public String value() { return code; }

public static TipoCuentaPBF valueOfCode(String code) {
  return Stream.of(values()).parallel().filter(c -> c.code.equals(code))
	.findAny()
	.orElseThrow(() -> new RuntimeException("Value not found " + code));
}


}
