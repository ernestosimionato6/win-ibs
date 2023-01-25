package sdn.piano.ibs.dd.domain;

import lombok.*;

//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CuentaPBF {
public TipoCuentaPBF tipoCuenta;
public String numeroCuenta;

public static CuentaPBF of(TipoCuentaPBF tipoCuenta, String numeroCuenta) {
return new CuentaPBF(tipoCuenta, numeroCuenta);
}

@Override
public String toString() { return String.format("%s-%s", numeroCuenta, tipoCuenta.code); }
}
