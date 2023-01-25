package sdn.piano.ibs.dd.domain;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DebitoRealizado {

public String nroComprobante;

public String codigoEmpresa;
public String nombreEmpresa;

public String concepto;

public String idCliente;

public String fechaVencimiento;
public String monto;
public String moneda;

public CuentaPBF cuenta;

public String referencia;
public String estadoDebito;

}
