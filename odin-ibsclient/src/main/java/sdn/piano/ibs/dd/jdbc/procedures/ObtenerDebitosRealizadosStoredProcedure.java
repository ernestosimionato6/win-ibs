package sdn.piano.ibs.dd.jdbc.procedures;

import org.springframework.util.LinkedCaseInsensitiveMap;

import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.metadata.CallMetaDataContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;

import java.util.*;
import java.util.stream.*;

import sdn.piano.ibs.dd.jdbc.mapper.*;
import sdn.piano.ibs.dd.jdbc.model.*;

import sdn.lang.text.TextTable;

import static sdn.util.SdnMaps.*;

public class ObtenerDebitosRealizadosStoredProcedure extends StoredProcedure {

public static IBSDebitoRealizadoMapper mapper;

static {
  mapper = new IBSDebitoRealizadoMapper();
}

private static final String PROCEDURE_NAME = "sgl_ebfCons_DebAut_Realizado";

public ObtenerDebitosRealizadosStoredProcedure(DataSource dataSource) {
  super(dataSource, PROCEDURE_NAME);
  declareParameter(new SqlParameter("tipoCuentaPBF", Types.VARCHAR));
  declareParameter(new SqlParameter("cuecodPBF", Types.VARCHAR));
  declareParameter(new SqlOutParameter("timeStamp", Types.VARCHAR));
  declareParameter(new SqlOutParameter("descResultado", Types.VARCHAR));
  compile();
}

@SuppressWarnings({"unchecked", "deprecated"})
public List<IBSDebitoRealizado> execute(String tipoCuenta, String nroCuenta) throws Exception {
  Map<String, Object> in = new HashMap<String, Object>();
  in.put("tipoCuentaPBF", tipoCuenta);
  in.put("cuecodPBF", nroCuenta);
  Map<String, Object> out = super.execute(in);
  ArrayList<LinkedCaseInsensitiveMap> resultSet = (ArrayList<LinkedCaseInsensitiveMap>)out.get("#result-set-1");
  System.out.println(TextTable.render(
	PROCEDURE_NAME + " - Resultset #1:",
	toMap(resultSet.get(0))
  ));
  List<IBSDebitoRealizado> debitosRealizados = new ArrayList<IBSDebitoRealizado>();
  resultSet.stream().forEach(r -> {
	try {
		debitosRealizados.add(mapper.map((Map<String, Object>)r));
	} catch ( Exception e ) { throw new RuntimeException(e); }
  });
  return debitosRealizados;
}

}

