package sdn.sucredito.windcoin.ibs.jdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class IBSDatosEntidad {

    public String actividad;
    public String calle;
    public String calleNumero;
    public String codigoEntidadBcra;
    public String codigoPostal;
    public String cuitEntidad;
    public String departamento;
    public String email;
    public String esPep;
    public String fechaInscripcionIgj;
    public String formaJuridica;
    public String idProvinciaBcra;
    public String idTipoCliente;
    public String localidad;
    public String numeroInscripcionRegistralIgj;
    public String piso;
    public String razonSocial;
}
