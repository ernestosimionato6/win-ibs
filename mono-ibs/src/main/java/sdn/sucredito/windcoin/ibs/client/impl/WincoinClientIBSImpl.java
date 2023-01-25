package sdn.sucredito.windcoin.ibs.client.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.cuenta.Cuenta;
import sdn.sucredito.wincoin.model.entidad.DatosEntidad;
import sdn.sucredito.wincoin.model.entidad.Representante;
import sdn.sucredito.windcoin.ibs.client.WincoinClientIBS;
import sdn.sucredito.windcoin.ibs.data.repositories.entidades.IBSCuentasRepository;
import sdn.sucredito.windcoin.ibs.data.repositories.entidades.IBSEntidadesRepository;
import sdn.sucredito.windcoin.ibs.data.repositories.entidades.impl.IBSCuentasRepositoryImpl;
import sdn.sucredito.windcoin.ibs.data.repositories.entidades.impl.IBSEntidadesRepositoryImpl;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;

import java.util.List;
import java.util.Optional;

@Data
@Builder
@AllArgsConstructor
public class WincoinClientIBSImpl
implements WincoinClientIBS {

    IBSConnectionPool pool;
    IBSEntidadesRepository entidadesRepository;
    IBSCuentasRepository cuentasRepository;

    public WincoinClientIBSImpl(
            IBSConnectionPool pool
    ) {
        this.pool = pool;
        this.entidadesRepository = new IBSEntidadesRepositoryImpl(pool);
        this.cuentasRepository = new IBSCuentasRepositoryImpl(pool);
    }


    @Override
    public Optional<DatosEntidad> obtenerDatosEntidad(
            Cuit cuitEntidad
    ) throws Exception {
        return entidadesRepository.obtenerDatosEntidadByCuit(cuitEntidad);
    }


    @Override
    public List<Representante> obtenerApoderados(
            Cuit cuitEntidad
    ) throws Exception {
        return entidadesRepository.obtenerApoderadosByCuitEntidad(cuitEntidad);
    }

    @Override
    public List<Representante> obtenerRepresentantes(
            Cuit cuitEntidad
    ) throws Exception {
        return entidadesRepository.obtenerRepresentantesByCuitEntidad(cuitEntidad);
    }

    @Override
    public List<Cuenta> obtenerCuentas(
            Cuit cuitEntidad,
            Cuit cuitRepresentante
    ) throws Exception {
        return cuentasRepository.obtenerCuentasByCuitEntidadYCuitRepresentante(
                cuitEntidad,
                cuitRepresentante
        );
    }
}
