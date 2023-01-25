package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class IdLocalidad {

    String value;

    public static IdLocalidad of(String raw) {
        return new IdLocalidad(raw);
    }
}
