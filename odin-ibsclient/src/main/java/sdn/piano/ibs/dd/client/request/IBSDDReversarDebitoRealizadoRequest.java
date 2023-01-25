package sdn.piano.ibs.dd.client.request;

import lombok.*;

import sdn.piano.ibs.dd.domain.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IBSDDReversarDebitoRealizadoRequest {

public String id;

public static IBSDDReversarDebitoRealizadoRequest of(String id) {
  return new IBSDDReversarDebitoRealizadoRequest(id);
}
}
