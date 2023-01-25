package sdn.piano.ibs.dd.domain;

import lombok.*;

//@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebitoAdherido {
    public String nroAdhesion;
    public String codigoEmpresa;
    public String concepto;
    @Builder.Default
    public String idCliente = "A";
    @Builder.Default
    public String moneda = "B";
    @Builder.Default
    public String fechaAdhesion = "C";
    public CuentaPBF cuenta; 
    @Builder.Default
    public String fechaVencimiento = "D";
    @Builder.Default
    public String monto = "E";
    @Builder.Default
    public String estadoAdhesion = "F";

   @Override
   public String toString() { return "DebitoAdherido[nroAdhesion: "+nroAdhesion+"]"; }
}   
