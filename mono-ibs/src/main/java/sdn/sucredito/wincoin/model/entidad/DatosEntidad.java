package sdn.sucredito.wincoin.model.entidad;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.persona.address.Direccion;
import sdn.sucredito.wincoin.model.persona.address.Provincia;
import sdn.sucredito.wincoin.model.persona.contacto.Email;

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
