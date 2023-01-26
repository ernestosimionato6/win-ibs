package sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.util.LinkedCaseInsensitiveMap;
import sdn.lang.text.text.TextTable;
import sdn.sucredito.windcoin.ibs.jdbc.IBSJDBCTemplate;
import sdn.sucredito.windcoin.ibs.jdbc.IBSJDBCUtil;
import sdn.sucredito.windcoin.ibs.jdbc.mapper.IBSRepresentanteMapper;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSRepresentante;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.IBSConstants;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class IBSObtenerRepresentantesStoredProcedureImpl extends StoredProcedure
    implements IBSObtenerRepresentantestoredProcedure {

    public static IBSRepresentanteMapper mapper;


    static {
        mapper = new IBSRepresentanteMapper();
    }

    private static final String PROCEDURE_NAME = "sdn_windcoin_entidad_representantes";

    public IBSObtenerRepresentantesStoredProcedureImpl(DataSource dataSource) {
        super(dataSource, PROCEDURE_NAME);
        setJdbcTemplate(new IBSJDBCTemplate(dataSource));
        setSql(PROCEDURE_NAME);

        declareParameter(new SqlParameter(IBSConstants.NRODOC, Types.VARCHAR));
       // declareParameter(new SqlParameter(IBSConstants.ES_ENTIDAD_FINANCIERA, Types.CHAR));
       // declareParameter(new SqlParameter(IBSConstants.CHECK_ONLY, Types.CHAR));
       // declareParameter(new SqlParameter(IBSConstants.CHECK_NRODOC__REPRESENTANTE, Types.VARCHAR));
       // declareParameter(new SqlOutParameter(IBSConstants.STATUS, Types.INTEGER));
        compile();
        out.println("[windcoin-ibs] " + PROCEDURE_NAME + " compiled.");

    }

    public List<IBSRepresentante> execute(String nrodoc, Boolean esEntidadFinanciera) throws Exception {
        System.out.println("[windcoint-ibs] " + PROCEDURE_NAME + " execute with nrodoc: " + nrodoc + " , es_entidad_financiera: " + esEntidadFinanciera);

        Map<String, Object> in = new HashMap<String, Object>();
        in.put(IBSConstants.NRODOC, nrodoc);
       // in.put(IBSConstants.ES_ENTIDAD_FINANCIERA, esEntidadFinanciera);

        Map<String, Object> out = super.execute(in);
        ArrayList<LinkedCaseInsensitiveMap> resultSet = (ArrayList<LinkedCaseInsensitiveMap>)out.get("#result-set-1");
        System.out.println("[windcoin-ibs] " + PROCEDURE_NAME + " resulset is: " + out.keySet() + " " + out);
        System.out.println(TextTable.render(
                "Resulset #1",
                IBSJDBCUtil.toMap(resultSet.get(0))
        ));

        List<IBSRepresentante> representantes = new ArrayList<>();

        resultSet.stream().forEach(r -> {
            try {
                representantes.add(mapper.map((Map<String, Object>)r));
            } catch (Exception e) { throw new RuntimeException(e); }
        });
        return representantes;
    }
}
