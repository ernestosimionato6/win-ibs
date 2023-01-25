package sdn.piano.ibs.dd.jdbc.model;

import lombok.*;

import java.math.BigDecimal;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IBSDebitoRealizado {

public BigDecimal idExtension;

public String empresa;

public IBSConcepto concepto;

public String desapenom;

public String fecaviso;

public BigDecimal monto;
public IBSMonCod moncod;

public IBSTipoCtaPbf tipoCtaPbf;
public String ctaPbf;

public String referencia;
public IBSEstadoDebito estadoDebito;
}
