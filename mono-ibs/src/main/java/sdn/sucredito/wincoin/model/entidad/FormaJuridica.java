package sdn.sucredito.wincoin.model.entidad;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class FormaJuridica {

    String value;

    public static FormaJuridica of(
            String raw
    )  {
        return new FormaJuridica(raw);
    }

}
