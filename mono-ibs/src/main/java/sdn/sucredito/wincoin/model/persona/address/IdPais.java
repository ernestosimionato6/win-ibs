package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class IdPais {

    String value;

    public static IdPais of(String raw) {
        return new IdPais(raw);
    }
}
