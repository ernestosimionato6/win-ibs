package sdn.sucredito.windcoin.ibs.jdbc.mapper;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.entidad.*;
import sdn.sucredito.wincoin.model.persona.EstadoCivil;
import sdn.sucredito.wincoin.model.persona.Genero;
import sdn.sucredito.wincoin.model.persona.address.*;
import sdn.sucredito.wincoin.model.persona.contacto.Email;
import sdn.sucredito.wincoin.model.persona.contacto.Telefono;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSRepresentante;

import java.util.Map;

import static sdn.sucredito.windcoin.ibs.jdbc.procedures.IBSConstants.*;

public class IBSRepresentanteMapper {

    public static IBSRepresentanteMapper instance;
    static {
        instance = new IBSRepresentanteMapper();
    }

    public IBSRepresentante map(Map<String, Object> rs) {
        return IBSRepresentante.builder()
           .actividad(rs.get(ACTIVIDAD).toString())
                .apellido(rs.get(APELLIDO).toString())
                .calle(rs.get(CALLE).toString())
                .calleNumero(rs.get(CALLE_NUMERO).toString())
                .codigoPostal(rs.get(CODIGO_POSTAL).toString())
                .cuit(rs.get(CUIT).toString())
                .departamento(rs.get(DEPARTAMENTO).toString())
                .email(rs.get(EMAIL).toString())
                .esPep(rs.get(ES_PEP).toString())
                .fechaNacimiento(rs.get(FECHA_NACIMIENTO).toString())
                .idEstadoCivil(rs.get(ID_ESTADO_CIVIL).toString())
                .idProvinciaBcra(rs.get(ID_PROVINCIA_BCRA).toString())
                .idSexo(rs.get(ID_SEXO).toString())
                .localidad(rs.get(LOCALIDAD).toString())
                .nombre(rs.get(NOMBRE).toString())
                .paisNacimiento(rs.get(PAIS_NACIMIENTO).toString())
                .piso(rs.get(PISO).toString())
                .telefono(rs.get(TELEFONO).toString())
                .build();
    }



    public Representante map(IBSRepresentante r) {
        return Representante.builder()
                .actividad(r.actividad)
                .apellido(r.apellido)
                .cuit(Cuit.of(r.cuit))
                .direccion( Direccion.builder()
                        .piso(r.piso)
                        .calle(r.calle)
                        .calleNumero(r.calleNumero)
                        .codigoPostal(CodigoPostal.of(r.codigoPostal))
                        .localidad(Localidad.of(r.localidad))
                        .build()
                )
                .estadoCivil(EstadoCivil.of(r.idEstadoCivil))
                .provincia(Provincia.of(r.idProvinciaBcra))
                .paisNacimiento(Pais.of(r.paisNacimiento))
                .email(Email.of(r.email))
                .telefono(Telefono.of(r.telefono))
                .genero(Genero.of(r.idSexo))
                .build();
    }
}
