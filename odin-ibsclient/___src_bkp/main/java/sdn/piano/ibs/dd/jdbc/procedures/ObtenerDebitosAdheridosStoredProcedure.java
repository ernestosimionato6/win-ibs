package sdn.piano.ibs.dd.jdbc.procedures;

import org.springframework.util.LinkedCaseInsensitiveMap;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.core.metadata.CallMetaDataContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.sql.Connection;
// import java.sql.DatabaseMetadata;
import java.sql.Types;
import javax.sql.DataSource;

import java.util.*;
import java.util.stream.*;


import sdn.piano.ibs.commons.jdbc.*;
import sdn.piano.ibs.dd.domain.*;
import sdn.lang.text.TextTable; 
import sdn.piano.ibs.dd.jdbc.mapper.*;
import sdn.piano.ibs.dd.jdbc.model.*;

public class ObtenerDebitosAdheridosStoredProcedure extends StoredProcedure {

public static IBSDebitoAdheridoMapper mapper;


static {
  mapper = new IBSDebitoAdheridoMapper();
}

private static final String PROCEDURE_NAME = "sgl_ebfCons_DebAut_Adherido";

public static Set<String> columns;
static {
columns  = new HashSet<String>();
columns.add("idnroadhesion");
columns.add("entidadcod");
columns.add("concepto");
columns.add("Desapenom");
columns.add("moncod");
columns.add("Fecadhesion");
columns.add("tipo_cta_pbf");
columns.add("cta_pbf");
columns.add("Fecha_vencimiento");
columns.add("Monto");
columns.add("Estado");
}


@SuppressWarnings({"unchecked", "deprecated"})
public ObtenerDebitosAdheridosStoredProcedure(DataSource dataSource) {
    super(dataSource, PROCEDURE_NAME);
    setJdbcTemplate(new IBSJDBCTemplate(dataSource));
    setSql(PROCEDURE_NAME);

    declareParameter(new SqlParameter("tipoCuentaPBF", Types.VARCHAR));
    declareParameter(new SqlParameter("cuecodPBF", Types.VARCHAR));
    declareParameter(new SqlOutParameter("timeStamp", Types.VARCHAR));
    declareParameter(new SqlOutParameter("codResultado",  Types.VARCHAR));
    declareParameter(new SqlOutParameter("descResultado", Types.VARCHAR)); 
    compile();
    System.out.println("... construct obtener_debitos_adheridos__store_procedure #" + this);
}

@SuppressWarnings({"unchecked", "deprecated"})
public List<IBSDebitoAdherido> execute(String tipoCuenta, String nroCuenta) throws Exception {
    Map<String, Object> in = new HashMap<String, Object>();
    in.put("tipoCuentaPBF", tipoCuenta);
    in.put("cuecodPBF", nroCuenta);
    Map<String, Object> out = super.execute(in);
    ArrayList<LinkedCaseInsensitiveMap> resultSet = (ArrayList<LinkedCaseInsensitiveMap>)out.get("#result-set-1");
    System.out.println(TextTable.render(
        "Resulset #1", 
        toMap(resultSet.get(0))
    ));
    List<IBSDebitoAdherido> debitosAdheridos = new ArrayList<IBSDebitoAdherido>();
    resultSet.stream().forEach(r -> {
	try {
	debitosAdheridos.add(mapper.map((Map<String, Object>)r));
	} catch (Exception e) { throw new RuntimeException(e); }
    });
    return debitosAdheridos;
}

@SuppressWarnings({"unchecked", "deprecated"})
public Map<String, Object> toMap(LinkedCaseInsensitiveMap rs) {
 Map<String, Object> props = new HashMap<String, Object>();
 System.out.println(rs.getClass()); 
 rs.keySet().stream().forEach(k -> {
	props.put(k.toString(), rs.get(k));
 }); 
 return props;
}

}
