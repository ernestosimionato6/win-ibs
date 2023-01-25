package sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl;

import sdn.sucredito.windcoin.ibs.jdbc.model.IBSDatosEntidad;

import java.util.Optional;

public interface IBSObtenerDatosEntidadStoredProcedure {

    Optional<IBSDatosEntidad> execute(String nrodoc) throws Exception;
}
