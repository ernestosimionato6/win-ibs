package sdn.sucredito.wincoin.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Cbu {

    String value;

    public static Cbu of(String raw) {
        return new Cbu(raw);
    }
}
