package sdn.piano.ibs.dd.client.request;

import lombok.*;

import sdn.piano.ibs.dd.domain.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IBSDDPausarDebitoAdheridoRequest {

public String idAdhesion;

public static IBSDDPausarDebitoAdheridoRequest of(String idAdhesion) {
  return new IBSDDPausarDebitoAdheridoRequest(idAdhesion);
}
}
