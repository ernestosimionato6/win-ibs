package sdn.sucredito.wincoin.model.cuenta;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import sdn.sucredito.wincoin.model.Cbu;
import sdn.sucredito.wincoin.model.moneda.Moneda;

@Data
@ToString
@Builder
public class Cuenta {

    Cbu cbu;
    Moneda moneda;
    CuentaPBF cuentaPBF;

    CuentaTipo cuentaTipo;
}

