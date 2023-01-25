package sdn.sucredito.wincoin.model.persona.contacto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class Telefono {

    String numero;

    public static Telefono of(String raw) {
        return new Telefono(raw);
    }
}
