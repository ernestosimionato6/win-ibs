package sdn.sucredito.windcoin.ibs.jdbc.mapper;

import org.springframework.util.LinkedCaseInsensitiveMap;
import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.entidad.*;
import sdn.sucredito.wincoin.model.persona.address.CodigoPostal;
import sdn.sucredito.wincoin.model.persona.address.Direccion;
import sdn.sucredito.wincoin.model.persona.address.Localidad;
import sdn.sucredito.wincoin.model.persona.address.Provincia;
import sdn.sucredito.wincoin.model.persona.contacto.Email;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSDatosEntidad;

import java.util.Optional;
import static java.util.Optional.of;

import static sdn.sucredito.windcoin.ibs.jdbc.procedures.IBSConstants.*;


public class IBSDatosEntidadMapper {

    public static IBSDatosEntidadMapper instance;
    static {
        instance = new IBSDatosEntidadMapper();
    }

    public IBSDatosEntidad map(LinkedCaseInsensitiveMap rs) {
       return IBSDatosEntidad.builder()
               .actividad(of(rs.get(ACTIVIDAD)).orElse("").toString())
               .calle(of(rs.get(CALLE)).orElse("").toString())
               .calleNumero(of(rs.get(CALLE_NUMERO)).orElse("").toString())
               .codigoEntidadBcra(of(rs.get(CODIGO_ENTIDAD_BCRA)).orElse("").toString())
               .codigoPostal(of(rs.get(CODIGO_POSTAL)).orElse("") .toString())
               .cuitEntidad(of(rs.get(CUIT_ENTIDAD) ).orElse("") .toString())
               .departamento(of(rs.get(DEPARTAMENTO)).orElse("")  .toString())
               .email(of(rs.get(EMAIL) ).orElse("")  .toString())
               .esPep(of(rs.get(ES_PEP) ).orElse("") .toString())
               .fechaInscripcionIgj(of(rs.get(FECHA_INSCRIPCION_IGJ) ).orElse("")  .toString())
               .formaJuridica(of(rs.get(FORMA_JURIDICA) ).orElse("")  .toString())
               .idProvinciaBcra(of(rs.get(ID_PROVINCIA_BCRA) ).orElse("")  .toString())
               .idTipoCliente(of(rs.get(ID_TIPO_CLIENTE) ).orElse("")  .toString())
               .localidad(of(rs.get(LOCALIDAD) ).orElse("")  .toString())
               .numeroInscripcionRegistralIgj(of(rs.get(NUMERO_INSCRIPCION_REGISTRAL_IGJ) ).orElse("")  .toString())
               .piso(of(rs.get(PISO) ).orElse("").toString())
               .razonSocial(of(rs.get(RAZON_SOCIAL)).orElse("").toString())
               .build();
    }

    public DatosEntidad map(IBSDatosEntidad r) {
        return DatosEntidad.builder()
                .pep(r.esPep.equals("S"))
                .cuit(Cuit.of(r.cuitEntidad))
                .razonSocial(r.razonSocial)
                .formaJuridica(FormaJuridica.of(r.formaJuridica))
                .actividad(r.actividad)
                .email(Email.of(r.email))
                .inscripcionIGJ(InscripcionIGJ.builder()
                        .numeroInscripcionIGJ(
                                NumeroInscripcionIGJ.of(r.numeroInscripcionRegistralIgj)
                        ).fechaInscripcionIGJ(r.fechaInscripcionIgj)
                        .build()
                )
                .provincia(Provincia.of(
                        r.idProvinciaBcra
                ))
                .codigoBCRA(
                        CodigoBCRA.of(r.codigoEntidadBcra)
                )
                .direccion( Direccion.builder()
                        .piso(r.piso)
                        .calle(r.calle)
                        .calleNumero(r.calleNumero)
                        .codigoPostal(CodigoPostal.of(r.codigoPostal))
                        .localidad(Localidad.of(r.localidad))
                        .build()
                )
                .build();
    }
}
