package sdn.sucredito.windcoin.ibs.data.repositories.entidades.impl;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.cuenta.Cuenta;
import sdn.sucredito.windcoin.ibs.data.repositories.entidades.IBSCuentasRepository;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;
import sdn.sucredito.windcoin.ibs.jdbc.IBSDataSource;
import sdn.sucredito.windcoin.ibs.jdbc.mapper.IBSCuentaMapper;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas.IBSObtenerCuentasStoredProcedure;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas.impl.IBSObtenerCuentasStoredProcedureImpl;

import java.util.List;
import java.util.stream.Collectors;

public class IBSCuentasRepositoryImpl implements IBSCuentasRepository {
    public IBSConnectionPool pool;
    public IBSDataSource dataSource;

    public IBSCuentasRepositoryImpl(
            IBSConnectionPool pool
    ) {
        this.pool = pool;
        this.dataSource = new IBSDataSource(pool);
    }

    @Override
    public List<Cuenta> obtenerCuentasByCuitEntidadYCuitRepresentante(Cuit cuitEntidad, Cuit cuitRepresentante) throws Exception {

        IBSCuentaMapper mapper = IBSCuentaMapper.instance;
        IBSObtenerCuentasStoredProcedure sp =
                new IBSObtenerCuentasStoredProcedureImpl(dataSource);

        return sp.execute(
                cuitEntidad.value(),
                cuitRepresentante.value()
        ).stream().map(mapper::map).collect(Collectors.toList());
    }
}
