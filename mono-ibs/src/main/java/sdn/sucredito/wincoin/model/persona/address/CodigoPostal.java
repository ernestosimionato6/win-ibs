package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.extern.java.Log;

@Data
@ToString
@Builder
public class CodigoPostal {

    String numero;

    public static CodigoPostal of(String raw) {
        return new CodigoPostal(raw);
    }
}
