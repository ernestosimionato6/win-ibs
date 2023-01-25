package sdn.sucredito.wincoin.model.entidad;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@ToString
@Data
public class CodigoBCRA {

    public String value;

    public static CodigoBCRA of(String raw) {
        return new CodigoBCRA(raw);
    }
}
