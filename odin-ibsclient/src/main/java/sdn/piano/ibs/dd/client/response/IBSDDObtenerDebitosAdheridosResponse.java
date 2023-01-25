package sdn.piano.ibs.dd.client.response;

import lombok.*;
import java.util.*;

import sdn.piano.ibs.dd.domain.DebitoAdherido;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class IBSDDObtenerDebitosAdheridosResponse {

public List<DebitoAdherido> debitosAdheridos; 

}
