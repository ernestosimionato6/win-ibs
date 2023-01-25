package sdn.piano.ibs.dd.client.request;

import lombok.*;

import sdn.piano.ibs.dd.domain.*;


@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IBSDDReanudarDebitoAdheridoRequest {

public String idAdhesion;

public static IBSDDReanudarDebitoAdheridoRequest of(String idAdhesion) {
  return new IBSDDReanudarDebitoAdheridoRequest(idAdhesion);
}
}
