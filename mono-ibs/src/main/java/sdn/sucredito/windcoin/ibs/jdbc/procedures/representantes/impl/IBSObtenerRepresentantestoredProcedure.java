package sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl;

import sdn.sucredito.windcoin.ibs.jdbc.model.IBSRepresentante;

import java.util.List;

public interface IBSObtenerRepresentantestoredProcedure {


    List<IBSRepresentante> execute(String nrodoc, Boolean esEntidadFinanciera) throws Exception;

}
