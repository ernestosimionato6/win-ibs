package sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas.impl;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.util.LinkedCaseInsensitiveMap;
import sdn.lang.text.text.TextTable;
import sdn.sucredito.windcoin.ibs.jdbc.IBSJDBCTemplate;
import sdn.sucredito.windcoin.ibs.jdbc.IBSJDBCUtil;
import sdn.sucredito.windcoin.ibs.jdbc.mapper.IBSCuentaMapper;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSCuenta;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.IBSConstants;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas.IBSObtenerCuentasStoredProcedure;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class IBSObtenerCuentasStoredProcedureImpl extends StoredProcedure implements IBSObtenerCuentasStoredProcedure {

    public static IBSCuentaMapper mapper;

    static {
        mapper = new IBSCuentaMapper();
    }

    private static final String PROCEDURE_NAME = "sdn_windcoin_representante_cuentas";

    public IBSObtenerCuentasStoredProcedureImpl(DataSource dataSource) {

        super(dataSource, PROCEDURE_NAME);
        setJdbcTemplate(new IBSJDBCTemplate(dataSource));
        setSql(PROCEDURE_NAME);

        declareParameter(new SqlParameter(IBSConstants.NRODOC, Types.VARCHAR));
        declareParameter(new SqlParameter(IBSConstants.NRODOC__REPRESENTANTE, Types.VARCHAR));
        declareParameter(new SqlOutParameter(IBSConstants.STATUS, Types.INTEGER));
        compile();
        out.println("[windcoin-ibs] " + PROCEDURE_NAME + " compiled.");
    }

    @Override
    public List<IBSCuenta> execute(String nrodoc, String nrodocRepresentante) throws Exception {

        System.out.println("[windcoint-ibs] " + PROCEDURE_NAME + " execute with nrodoc: " + nrodoc + " , nrodocRepresentante: " + nrodocRepresentante);

        Map<String, Object> in = new HashMap<String, Object>();
        in.put(IBSConstants.NRODOC, nrodoc);
        in.put(IBSConstants.NRODOC__REPRESENTANTE, nrodocRepresentante);

        Map<String, Object> out = super.execute(in);
        ArrayList<LinkedCaseInsensitiveMap> resultSet = (ArrayList<LinkedCaseInsensitiveMap>)out.get("#result-set-1");
        System.out.println("[windcoin-ibs] " + PROCEDURE_NAME + " resulset is: " + out.keySet() + " " + out);
        System.out.println(TextTable.render(
                "Resulset #1",
                IBSJDBCUtil.toMap(resultSet.get(0))
        ));

        List<IBSCuenta> cuentas = new ArrayList<>();

        resultSet.stream().forEach(r -> {
            try {
                cuentas.add(mapper.map((Map<String, Object>)r));
            } catch (Exception e) { throw new RuntimeException(e); }
        });
        return cuentas;
    }
}
