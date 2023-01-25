package sdn.piano.ibs.dd.client.request;

import lombok.*;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IBSDDObtenerDebitosAdheridosRequest {

public String tipoCuenta;
public String nroCuenta;

public static IBSDDObtenerDebitosAdheridosRequest of(String tipoCuenta, String nroCuenta) {
  return new IBSDDObtenerDebitosAdheridosRequest(tipoCuenta, nroCuenta);
}

}
