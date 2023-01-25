package sdn.sucredito.windcoin.ibs.jdbc.mapper;

import sdn.sucredito.windcoin.ibs.jdbc.model.IBSRepresentante;

import java.util.Map;

public class IBSEntidadMapper {
    public IBSRepresentante map(Map<String, Object> r) {
        return new IBSRepresentante();
    }
}
