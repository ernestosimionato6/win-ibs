package sdn.sucredito.windcoin.ibs.jdbc.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@ToString
@Data
@Builder
public class IBSCuenta {

    public String cuentaCbu;
    public String cuentaMoneda;  // varchar(3)
    public String cuentaPbf;     // varchar(17)
    public String cuentaTipo;
}
