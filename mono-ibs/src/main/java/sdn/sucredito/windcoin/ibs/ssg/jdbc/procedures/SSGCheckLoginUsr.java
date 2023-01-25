package sdn.sucredito.windcoin.ibs.ssg.jdbc.procedures;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import sdn.sucredito.windcoin.ibs.ssg.jdbc.mapper.SSGUsrCredentialsMapper;
import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;

import java.sql.Types;
import javax.sql.DataSource;

import java.util.*;

import static sdn.sucredito.windcoin.ibs.ssg.jdbc.SSGConstants.*;

/**
 *   EXECUTE ssg_check_login_usr
 *   @entidadcodpar=1057,
 *   @entidadpasswpar='PSW CENSYS',
 *   @paiscod=54,
 *   @bcocod=301,
 *   @succod=1,
 *   @tipdoc=88,
 *   @usrident=2000001,
 *   @tercod=17690,
 *   @origpaiscod=54,
 *   @origbcocod=301,
 *   @origsuccod=1,
 *   @concepto='H2H',
 *   @tipo_print=1
 *
 */
public class SSGCheckLoginUsr extends StoredProcedure {

  private static final String PROCEDURE_NAME = "ssg_check_login_usr";

    public static SSGUsrCredentialsMapper mapper;
  static {
	mapper = new SSGUsrCredentialsMapper();
  }

  public SSGCheckLoginUsr(DataSource dataSource) {
     super(dataSource, PROCEDURE_NAME);
     declareParameter(new SqlParameter(ENTIDADCODPAR, Types.NUMERIC));
     declareParameter(new SqlParameter(ENTIDADPASSWPAR, Types.VARCHAR));
     declareParameter(new SqlParameter(PAISCOD, Types.NUMERIC));
     declareParameter(new SqlParameter(BCOCOD, Types.NUMERIC));
     declareParameter(new SqlParameter(SUCCOD, Types.NUMERIC));
     declareParameter(new SqlParameter(TIPDOC, Types.NUMERIC));
     declareParameter(new SqlParameter(USRIDENT, Types.NUMERIC));
     declareParameter(new SqlParameter(TERCOD, Types.NUMERIC));
     declareParameter(new SqlParameter(ORIGPAISCOD, Types.NUMERIC));
     declareParameter(new SqlParameter(ORIGBCOCOD, Types.NUMERIC));
     declareParameter(new SqlParameter(ORIGSUCCOD, Types.NUMERIC));
     // declareParameter(new SqlParameter(CONCEPTO, Types.VARCHAR));
     // declareParameter(new SqlParameter(TIPO_PRINT, Types.NUMERIC));
     compile();
  }

  @SuppressWarnings({"deprecated"})
  public void execute(SSGUsrCredentials credentials) throws Exception {
    	Map<String, Object> in = mapper.map(credentials);
	Map<String, Object> out = super.execute(in);
	System.out.println(" ssg_check_login_usr perform with " + in + " and result in " + out);
  }

}


