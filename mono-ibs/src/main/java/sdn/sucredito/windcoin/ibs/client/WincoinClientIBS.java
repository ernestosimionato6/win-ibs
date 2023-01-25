package sdn.sucredito.windcoin.ibs.client;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.cuenta.Cuenta;
import sdn.sucredito.wincoin.model.entidad.DatosEntidad;
import sdn.sucredito.wincoin.model.entidad.Representante;

import java.util.List;
import java.util.Optional;

public interface WincoinClientIBS {

    List<Cuenta> obtenerCuentas(Cuit cuitEntidad, Cuit cuitRepresentante) throws Exception;
    List<Representante> obtenerApoderados( Cuit cuitEntidad ) throws Exception;
    List<Representante> obtenerRepresentantes(Cuit cuitEntidad) throws Exception;
    Optional<DatosEntidad> obtenerDatosEntidad( Cuit cuitEntidad ) throws Exception;

}
