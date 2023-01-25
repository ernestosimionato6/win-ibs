package sdn.sucredito.wincoin.model.cuenta;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class CuentaPBF {
    public String value;

    public static CuentaPBF of(String raw) {
        return new CuentaPBF(raw);
    }
}
