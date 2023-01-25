package sdn.sucredito.wincoin.model.cuenta;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CuentaTipo {


    public String value;

    public static CuentaTipo of(String raw) {
        return new CuentaTipo(raw);
    }
}
