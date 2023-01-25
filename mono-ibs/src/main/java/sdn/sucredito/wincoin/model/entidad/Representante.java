package sdn.sucredito.wincoin.model.entidad;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.persona.EstadoCivil;
import sdn.sucredito.wincoin.model.persona.address.Direccion;
import sdn.sucredito.wincoin.model.persona.address.Pais;
import sdn.sucredito.wincoin.model.persona.address.Provincia;
import sdn.sucredito.wincoin.model.persona.contacto.Email;
import sdn.sucredito.wincoin.model.persona.contacto.Telefono;
import sdn.sucredito.wincoin.model.persona.Genero;

public class Representante {

    Boolean pep;

    Cuit cuit;

    String actividad;
    String apellido;

    Direccion direccion;

    EstadoCivil estadoCivil;

    Provincia idProvincia;

    Pais paisNacimiento;

    Email email;

    Telefono telefono;


    Genero genero;


}
