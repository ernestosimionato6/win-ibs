package sdn.piano.ibs.dd.jdbc.mapper;

import sdn.data.jdbc.*;
import sdn.piano.ibs.dd.jdbc.model.*;

import java.util.*;
import java.math.*;


public class IBSDebitoRealizadoMapper implements Mapper<IBSDebitoRealizado> {

@Override
public IBSDebitoRealizado map(Map<String, Object> rs) throws Exception {
  return IBSDebitoRealizado.builder()
	.idExtension((BigDecimal)rs.get("id_extension"))
	.empresa((String)rs.get("Empresa"))
	.concepto(IBSConcepto.valueOfCode(rs.get("concepto").toString()))
	.desapenom((String)rs.get("desapenom"))
	.fecaviso(rs.get("fecaviso").toString()) // com.sybase.jdbc4.tds.SybTimestamp # 2000-00-00 00:00:00.0 #
	.monto((BigDecimal)rs.get("Monto"))
	.moncod(IBSMonCod.valueOfCode(rs.get("moncod").toString()))
	.tipoCtaPbf(IBSTipoCtaPbf.valueOfCode(rs.get("tipo_cta_pbf").toString()))
	.ctaPbf((String)rs.get("cta_pbf"))
	.referencia((String)rs.get("Referencia"))
	.estadoDebito(IBSEstadoDebito.valueOf(rs.get("EstadoDebito").toString()))
	.build();
}

}
