package sdn.piano.ibs.dd.jdbc.model;

import java.util.*;
import java.util.stream.*;

public enum IBSTipoCtaPbf {
CUENTA_CORRIENTE_PESOS("01"),
CUENTA_CORRIENTE_DOLARES("07"),
CAJA_DE_AHORROS_EN_PESOS("11"),
CAJA_DE_AHORROS_EN_DOLARES("15");

public String code;
IBSTipoCtaPbf(String code) {
this.code = code;
}

public static IBSTipoCtaPbf valueOfCode(String code) {
 return Stream.of(values()).parallel().filter(t -> t.code.equals(code))
	.findAny()
	.orElseThrow(() -> new RuntimeException("Value not found " + code));
}

}
