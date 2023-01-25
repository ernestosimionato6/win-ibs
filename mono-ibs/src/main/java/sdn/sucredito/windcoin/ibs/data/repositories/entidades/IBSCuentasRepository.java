package sdn.sucredito.windcoin.ibs.data.repositories.entidades;

import sdn.sucredito.wincoin.model.cuenta.Cuenta;
import sdn.sucredito.wincoin.model.Cuit;

import java.util.List;

public interface IBSCuentasRepository {

    List<Cuenta> obtenerCuentasByCuitEntidadYCuitRepresentante(Cuit cuitEntidad, Cuit cuitRepresentante) throws Exception;
}
