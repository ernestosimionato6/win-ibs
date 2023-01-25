package sdn.piano.ibs.dd.client.response;

import lombok.*;
import java.util.*;

import sdn.piano.ibs.dd.domain.DebitoRealizado;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IBSDDObtenerDebitosRealizadosResponse {

public List<DebitoRealizado> debitosRealizados;

}
