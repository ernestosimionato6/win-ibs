package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class IdProvinciaBCRA {

    String id;

    public static IdProvinciaBCRA of(String raw) {
        return new IdProvinciaBCRA(raw);
    }
}
