package sdn.piano.ibs.dd.jdbc.model;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IBSDebitoAdherido {

public BigDecimal idnroadhesion;
public IBSTipoCtaPbf tipoCtaPbf;
public IBSMonCod moncod;
public String desapenom;
public BigDecimal monto; // 0.00
public String fecadhesion;
public IBSConcepto concepto;
public String fechaVencimiento;
public String ctaPbf;
public String entidadnom; 
public IBSEstadoAdhesion estado;
}
