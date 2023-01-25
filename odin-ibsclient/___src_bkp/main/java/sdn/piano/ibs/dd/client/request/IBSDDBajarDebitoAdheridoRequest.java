package sdn.piano.ibs.dd.client.request;

import lombok.*;

import sdn.piano.ibs.dd.domain.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IBSDDBajarDebitoAdheridoRequest {

public String idAdhesion;

public static IBSDDBajarDebitoAdheridoRequest of(String idAdhesion) {
  return new IBSDDBajarDebitoAdheridoRequest(idAdhesion);
}
}
