package sdn.sucredito.wincoin.model.persona.address;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Direccion {

    String piso;

    String calle;
    String calleNumero;

    CodigoPostal codigoPostal;

    Localidad localidad;

}
