/* 
package sdn.piano.ibs.dd.jdbc.procedures;

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

public class ObtenerDebitosAdheridosStoredProcedure extends StoredProcedure {

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


public ObtenerDebitosAdheridosStoredProcedure(DataSource dataSource) {
    super(dataSource, PROCEDURE_NAME);
    declareParameter(new SqlInOutParameter("tipoCuentaPBF", Types.VARCHAR));
    declareParameter(new SqlInOutParameter("cuecodPBF", Types.VARCHAR));
    declareParameter(new SqlOutParameter("timeStamp", Types.VARCHAR));
    declareParameter(new SqlOutParameter("codResultado",  Types.VARCHAR));
    declareParameter(new SqlOutParameter("descResultado", Types.VARCHAR)); 
    compile();
}

public List<DebitoAdherido> execute(String tipoCuenta, String nroCuenta) {
    Map<String, Object> in = new HashMap<String, Object>();
    in.put("tipoCuentaPBF", tipoCuenta);
    in.put("cuecodPBF", nroCuenta);
    Map<String, Object> out = super.execute(in);
    List<DebitoAdherido> debitosAdheridos = new ArrayList<DebitoAdherido>();
    return debitosAdheridos;
}
}

class DebitoAdherido {
    public String tipoCuenta;
    public String nroCuenta;
}
*/
