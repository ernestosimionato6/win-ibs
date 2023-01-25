package sdn.sucredito.wincoin.model.entidad;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class NumeroInscripcionIGJ {

    public String value;

    public static NumeroInscripcionIGJ of(
            String raw
    ) {
        return new NumeroInscripcionIGJ(raw);
    }
}
