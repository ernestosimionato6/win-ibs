package sdn.sucredito.windcoin.ibs.data.repositories.entidades.impl;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.entidad.DatosEntidad;
import sdn.sucredito.wincoin.model.entidad.Representante;
import sdn.sucredito.windcoin.ibs.data.repositories.entidades.IBSEntidadesRepository;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;
import sdn.sucredito.windcoin.ibs.jdbc.IBSDataSource;
import sdn.sucredito.windcoin.ibs.jdbc.mapper.IBSDatosEntidadMapper;
import sdn.sucredito.windcoin.ibs.jdbc.mapper.IBSRepresentanteMapper;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl.IBSObtenerDatosEntidadStoredProcedure;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl.IBSObtenerDatosEntidadStoredProcedureImpl;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl.IBSObtenerRepresentantesStoredProcedureImpl;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl.IBSObtenerRepresentantestoredProcedure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class IBSEntidadesRepositoryImpl implements IBSEntidadesRepository  {


    public IBSConnectionPool pool;
    public IBSDataSource dataSource;

    public IBSEntidadesRepositoryImpl(
            IBSConnectionPool pool
    ) {
        this.pool = pool;
        this.dataSource = new IBSDataSource(pool);
    }

    @Override
    public Optional<DatosEntidad> obtenerDatosEntidadByCuit(Cuit cuitEntidad)
        throws Exception {

        IBSDatosEntidadMapper mapper = IBSDatosEntidadMapper.instance;
        IBSObtenerDatosEntidadStoredProcedure sp =
                new IBSObtenerDatosEntidadStoredProcedureImpl(dataSource);

        return sp.execute(cuitEntidad.value()).map( mapper::map );
    }

    @Override
    public List<Representante> obtenerApoderadosByCuitEntidad(
            Cuit cuitEntidad
    ) throws Exception {

        IBSRepresentanteMapper mapper = IBSRepresentanteMapper.instance;
        IBSObtenerRepresentantestoredProcedure sp =
                new IBSObtenerRepresentantesStoredProcedureImpl(dataSource);

        return sp.execute(cuitEntidad.value(), true)
                .stream().map(mapper::map).collect(Collectors.toList());
    }


    @Override
    public List<Representante> obtenerRepresentantesByCuitEntidad(
            Cuit cuitEntidad
    ) throws Exception {

        IBSRepresentanteMapper mapper = IBSRepresentanteMapper.instance;
        IBSObtenerRepresentantestoredProcedure sp =
                new IBSObtenerRepresentantesStoredProcedureImpl(dataSource);

        return sp.execute(cuitEntidad.value(), true)
                .stream().map(mapper::map).collect(Collectors.toList());
    }
}
