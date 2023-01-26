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
           .actividad(rs.getOrDefault(ACTIVIDAD, "").toString())
                .apellido(rs.getOrDefault(APELLIDO, "").toString())
                .calle(rs.getOrDefault(CALLE, "").toString())
                .calleNumero(rs.getOrDefault(CALLE_NUMERO, "").toString())
                .codigoPostal(rs.getOrDefault(CODIGO_POSTAL, "").toString())
                .cuit(rs.getOrDefault(CUIT, "").toString())
                .departamento(rs.getOrDefault(DEPARTAMENTO, "").toString())
                .email(rs.getOrDefault(EMAIL, "").toString())
                .esPep(rs.getOrDefault(ES_PEP, "").toString())
                .fechaNacimiento(rs.getOrDefault(FECHA_NACIMIENTO, "").toString())
                .idEstadoCivil(rs.getOrDefault(ID_ESTADO_CIVIL, "").toString())
                .idProvinciaBcra(rs.getOrDefault(ID_PROVINCIA_BCRA, "").toString())
                .idSexo(rs.getOrDefault(ID_SEXO, "").toString())
                .localidad(rs.getOrDefault(LOCALIDAD, "").toString())
                .nombre(rs.getOrDefault(NOMBRE, "").toString())
                .paisNacimiento(rs.getOrDefault(PAIS_NACIMIENTO, "").toString())
                .piso(rs.getOrDefault(PISO, "").toString())
                .telefono(rs.getOrDefault(TELEFONO, "").toString())
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
