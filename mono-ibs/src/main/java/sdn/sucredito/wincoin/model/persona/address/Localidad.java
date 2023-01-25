package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Localidad {

    IdLocalidad idLocalidad;

    public static Localidad of(String raw) {
        return new Localidad(
                IdLocalidad.of(raw)
        );
    }
}
