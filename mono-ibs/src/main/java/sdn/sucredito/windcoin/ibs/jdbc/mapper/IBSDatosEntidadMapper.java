package sdn.sucredito.windcoin.ibs.jdbc.mapper;

import org.springframework.util.LinkedCaseInsensitiveMap;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSDatosEntidad;

public class IBSDatosEntidadMapper {

    public IBSDatosEntidad map(LinkedCaseInsensitiveMap linkedCaseInsensitiveMap) {
       return new IBSDatosEntidad();
    }
}
