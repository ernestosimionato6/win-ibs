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
import sdn.piano.ibs.dd.domain.*;
import sdn.piano.ibs.dd.jdbc.mapper.*;
import sdn.piano.ibs.dd.jdbc.model.*;

import java.math.*;

public class PausarDebitoStoredProcedure extends StoredProcedure {

private static final String PROCEDURE_NAME = "sgl_ebfPausa_DebAut_StopDebit";

public PausarDebitoStoredProcedure(DataSource dataSource) {
  super(dataSource, PROCEDURE_NAME);
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
  System.out.println("[@debug] " + PROCEDURE_NAME + " performed with " + in + " return " + out);
  return new IBSTramite();
}

}

class IBSPausarDebitoMapper {
}
