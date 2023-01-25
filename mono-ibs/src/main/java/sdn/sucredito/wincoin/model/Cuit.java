package sdn.sucredito.wincoin.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Cuit {

    String numero;

    public String value() { return numero; }

    public static Cuit of(String numero) {
        return new Cuit(numero);
    }
}
