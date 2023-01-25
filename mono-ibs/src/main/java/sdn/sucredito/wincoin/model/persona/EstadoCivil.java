package sdn.sucredito.wincoin.model.persona;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class EstadoCivil {

    String value;

    public static EstadoCivil of(String raw) {
        return new EstadoCivil(raw);
    }
}
