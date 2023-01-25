package sdn.piano.ibs.dd.client.request;

import lombok.*;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IBSDDObtenerDebitosRealizadosRequest  {

public String tipoCuenta;
public String nroCuenta;

public static IBSDDObtenerDebitosRealizadosRequest of(String tipoCuenta, String nroCuenta) {
 return new IBSDDObtenerDebitosRealizadosRequest(tipoCuenta, nroCuenta);
}

}
