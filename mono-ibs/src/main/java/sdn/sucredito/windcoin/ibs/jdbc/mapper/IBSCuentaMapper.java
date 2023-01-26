package sdn.sucredito.windcoin.ibs.jdbc.mapper;

import sdn.sucredito.wincoin.model.Cbu;
import sdn.sucredito.wincoin.model.cuenta.Cuenta;
import sdn.sucredito.wincoin.model.cuenta.CuentaPBF;
import sdn.sucredito.wincoin.model.cuenta.CuentaTipo;
import sdn.sucredito.wincoin.model.moneda.Moneda;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSCuenta;

import java.util.Map;

import static sdn.sucredito.windcoin.ibs.jdbc.procedures.IBSConstants.*;

public class IBSCuentaMapper {
    public static IBSCuentaMapper instance;
    static {
        instance = new IBSCuentaMapper();
    }

    public IBSCuenta map(Map<String, Object> rs) {

        return IBSCuenta.builder()
                .cuentaCbu(rs.get(CUENTA_CBU).toString())
                .cuentaMoneda(rs.get(CUENTA_MONEDA).toString())
                .cuentaPbf(rs.get(CUENTA_PBF).toString())
                .cuentaTipo(rs.get(CUENTA_TIPO).toString())
                .build();
    }

    public Cuenta map(IBSCuenta r) {
        return Cuenta.builder()
               .cbu(Cbu.of(r.cuentaCbu))
               .moneda(Moneda.of(r.cuentaMoneda))
               .cuentaPBF(CuentaPBF.of(r.cuentaPbf))
               .cuentaTipo(CuentaTipo.of(r.cuentaTipo))
               .build();
    }
}
