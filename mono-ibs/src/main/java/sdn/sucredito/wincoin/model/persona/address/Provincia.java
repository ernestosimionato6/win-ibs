package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Builder
@Data
@ToString
public class Provincia {

    IdProvinciaBCRA idProvinciaBCRA;

    public static Provincia of(String idProvinciaBcra) {
        return new Provincia(
                IdProvinciaBCRA.of(idProvinciaBcra)
        );
    }
}
