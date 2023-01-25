package sdn.sucredito.wincoin.model.entidad;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class InscripcionIGJ {

    String fechaInscripcionIGJ; // yyyy-mm-ddThh:mm:ss

    NumeroInscripcionIGJ numeroInscripcionIGJ;


}
