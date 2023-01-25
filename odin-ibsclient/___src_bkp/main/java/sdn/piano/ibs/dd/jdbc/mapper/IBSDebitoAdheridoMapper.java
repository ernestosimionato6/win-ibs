package sdn.piano.ibs.dd.jdbc.mapper;

import sdn.data.jdbc.*;
import sdn.piano.ibs.dd.jdbc.model.*;

import java.util.*;
import java.math.*;

public class IBSDebitoAdheridoMapper implements Mapper<IBSDebitoAdherido> {

@Override
public IBSDebitoAdherido map(Map<String, Object> rs) throws Exception {
   // System.out.println(rs);
   return IBSDebitoAdherido.builder()
		.idnroadhesion((BigDecimal)rs.get("id_adhesion_link"))
		.tipoCtaPbf(IBSTipoCtaPbf.valueOfCode(rs.get("tipo_cta_pbf").toString()))
		.moncod(IBSMonCod.valueOfCode(rs.get("moncod").toString()))
		.desapenom((String)rs.get("Desapenom"))
		.monto((BigDecimal)rs.get("Monto"))
		.fecadhesion(Optional.ofNullable(rs.get("fecadhesion")).orElse("").toString())
		.concepto(IBSConcepto.valueOfCode(rs.get("concepto").toString()))
		.fechaVencimiento((String)rs.get("Fecha_vencimiento").toString())
		.ctaPbf((String)rs.get("cta_pbf"))
		.entidadnom((String)rs.get("entidadnom"))
		.estado(IBSEstadoAdhesion.valueOf(rs.get("Estado").toString()))
		.build();
}

}
