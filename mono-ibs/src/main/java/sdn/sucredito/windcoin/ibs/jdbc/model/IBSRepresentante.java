package sdn.sucredito.windcoin.ibs.jdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class IBSRepresentante {

   public String actividad;
   public String apellido;
   public String calle;
   public String calleNumero;
   public String codigoPostal;
   public String cuit; // varchar(11)
   public String departamento;
   public String email;
   public String esPep;
   public String fechaNacimiento;  // varchar(19)  yyyy-mm-ddThh:mm:ss
   public String idEstadoCivil;   // varchar(2)
   public String idProvinciaBcra;  // varchar(2)
   public String idSexo;  // varchar(2)
   public String localidad;
   public String nombre;
   public String paisNacimiento;
   public String piso;
   public String telefono;
}
