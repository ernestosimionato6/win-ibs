package sdn.sucredito.wincoin.model.entidad;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.persona.address.Direccion;
import sdn.sucredito.wincoin.model.persona.address.Provincia;
import sdn.sucredito.wincoin.model.persona.contacto.Email;

@Data
@ToString
@Builder
public class DatosEntidad {

    Boolean pep;

    Cuit cuit;
    String razonSocial;

    FormaJuridica formaJuridica;

    String actividad;

    Email email;

    InscripcionIGJ inscripcionIGJ;

    Provincia provincia;

    CodigoBCRA codigoBCRA;
    Direccion direccion;

}
