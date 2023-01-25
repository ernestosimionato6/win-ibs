package sdn.sucredito.wincoin.model.moneda;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Moneda {

    String value;

    public static Moneda of(String raw) { return new Moneda(raw); }
}
