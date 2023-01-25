package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Pais {

    IdPais idPais;

    public static Pais of(String raw) {
        return new Pais(
                IdPais.of(raw)
        );
    }
}
