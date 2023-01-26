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

import static sdn.sucredito.windcoin.ibs.jdbc.procedures.IBSConstants.*;


public class IBSDatosEntidadMapper {

    public static IBSDatosEntidadMapper instance;
    static {
        instance = new IBSDatosEntidadMapper();
    }

    public IBSDatosEntidad map(LinkedCaseInsensitiveMap rs) {
       return IBSDatosEntidad.builder()
               .actividad(rs.get(ACTIVIDAD).toString())
               .calle(rs.get(CALLE).toString())
               .calleNumero(rs.get(CALLE_NUMERO).toString())
               .codigoEntidadBcra(rs.get(CODIGO_ENTIDAD_BCRA).toString())
               .codigoPostal(rs.get(CODIGO_POSTAL).toString())
               .cuitEntidad(rs.get(CUIT_ENTIDAD).toString())
               .departamento(rs.get(DEPARTAMENTO).toString())
               .email(rs.get(EMAIL).toString())
               .esPep(rs.get(ES_PEP).toString())
               .fechaInscripcionIgj(rs.get(FECHA_INSCRIPCION_IGJ).toString())
               .formaJuridica(rs.get(FORMA_JURIDICA).toString())
               .idProvinciaBcra(rs.get(ID_PROVINCIA_BCRA).toString())
               .idTipoCliente(rs.get(ID_TIPO_CLIENTE).toString())
               .localidad(rs.get(LOCALIDAD).toString())
               .numeroInscripcionRegistralIgj(rs.get(NUMERO_INSCRIPCION_REGISTRAL_IGJ).toString())
               .piso(rs.get(PISO).toString())
               .razonSocial(rs.get(RAZON_SOCIAL).toString())
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
