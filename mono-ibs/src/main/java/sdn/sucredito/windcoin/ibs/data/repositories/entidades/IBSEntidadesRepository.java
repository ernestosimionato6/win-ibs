package sdn.sucredito.windcoin.ibs.data.repositories.entidades;

import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.entidad.DatosEntidad;
import sdn.sucredito.wincoin.model.entidad.Representante;

import java.util.List;
import java.util.Optional;

public interface IBSEntidadesRepository {

    Optional<DatosEntidad> obtenerDatosEntidadByCuit(Cuit cuitEntidad);

    List<Representante> obtenerRepresentantesByCuitEntidadYTipo(Cuit cuitEntidad, Boolean incluirEntidadesFinancieras);

}
