package sdn.sucredito.wincoin.model.entidad;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.persona.EstadoCivil;
import sdn.sucredito.wincoin.model.persona.address.Direccion;
import sdn.sucredito.wincoin.model.persona.address.Pais;
import sdn.sucredito.wincoin.model.persona.address.Provincia;
import sdn.sucredito.wincoin.model.persona.contacto.Email;
import sdn.sucredito.wincoin.model.persona.contacto.Telefono;
import sdn.sucredito.wincoin.model.persona.Genero;

@Data
@ToString
@Builder
public class Representante {

    Boolean pep;

    Cuit cuit;

    String actividad;
    String apellido;

    Direccion direccion;

    EstadoCivil estadoCivil;

    Provincia provincia;

    Pais paisNacimiento;

    Email email;

    Telefono telefono;


    Genero genero;


}
