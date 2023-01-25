package sdn.piano.ibs.dd.jdbc.procedures;

import org.springframework.util.LinkedCaseInsensitiveMap;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.jdbc.core.metadata.CallMetaDataContext;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

// import java.sql.DatabaseMetadata;
import java.sql.Connection;
import java.sql.Types;
import javax.sql.DataSource;

import java.util.*;
import java.util.stream.*;

import sdn.lang.text.TextTable;

import sdn.piano.ibs.commons.jdbc.*;
import sdn.piano.ibs.dd.jdbc.model.*;
import sdn.piano.ibs.dd.jdbc.mapper.*;

import java.math.*;

import static sdn.util.SdnMaps.*;

public class PausarDebitoStoredProcedure extends StoredProcedure {

private static final String PROCEDURE_NAME = "sgl_ebfPausa_DebAut_StopDebit";

public DataSource ds;

public PausarDebitoStoredProcedure(DataSource dataSource) {
  super(dataSource, PROCEDURE_NAME);
  this.ds = dataSource;
  declareParameter(new SqlParameter("id", Types.NUMERIC));
  declareParameter(new SqlOutParameter("timeStamp", Types.VARCHAR));
  declareParameter(new SqlOutParameter("codResultado", Types.VARCHAR));
  declareParameter(new SqlOutParameter("descResultado", Types.VARCHAR));
  compile();
}


@SuppressWarnings({"unchecked", "deprecated"})
public IBSTramite execute(String idAdhesion) throws Exception {
  Map<String, Object> in = new HashMap<String, Object>();
  in.put("id", new BigDecimal(idAdhesion));
  Map<String, Object> out = super.execute(in);
  List<LinkedCaseInsensitiveMap> resultSet = (ArrayList<LinkedCaseInsensitiveMap>)out.get("#result-set-1");
  System.out.println(TextTable.render(
      "Resulset #1", 
      toMap(resultSet.get(0))
  ));

  System.out.println("[@debug] " + PROCEDURE_NAME + " performed with " + in + " return " + resultSet);
  return new IBSTramite(resultSet.get(0).get("numeroTramite").toString(), (String)resultSet.get(0).get("estadoTramite"));
}

}

//@SuppressWarnings({"unchecked", "deprecated"})
//public IBSTramite noexecute(String idAdhesion) throws Exception {
//  PausarDebitoJDBCTemplate jdbcTemplate = new PausarDebitoJDBCTemplate(ds.getConnection(), PROCEDURE_NAME); 
//  jdbcTemplate.execute(idAdhesion);
//  //SpCallJdbcTemplate jdbcTemplate = new SpCallJdbcTemplate(ds.getConnection()); 
//  // jdbcTemplate.execute("select host_name()");
//  // System.out.println("[@debug] " + PROCEDURE_NAME + " performed with " + in + " return " + out);
//  return new IBSTramite();
//}
