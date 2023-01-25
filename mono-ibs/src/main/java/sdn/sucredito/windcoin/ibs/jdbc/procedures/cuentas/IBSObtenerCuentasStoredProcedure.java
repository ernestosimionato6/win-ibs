package sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas;

import sdn.sucredito.windcoin.ibs.jdbc.model.IBSCuenta;

import java.util.List;

public interface IBSObtenerCuentasStoredProcedure {
    List<IBSCuenta> execute(String nrodoc, String nrodocRepresentante) throws Exception;
}
