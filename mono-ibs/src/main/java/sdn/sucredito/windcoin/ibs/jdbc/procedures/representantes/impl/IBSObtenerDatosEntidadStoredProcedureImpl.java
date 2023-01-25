package sdn.sucredito.windcoin.ibs.jdbc.procedures.representantes.impl;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.util.LinkedCaseInsensitiveMap;
import sdn.lang.text.text.TextTable;
import sdn.sucredito.windcoin.ibs.jdbc.IBSJDBCTemplate;
import sdn.sucredito.windcoin.ibs.jdbc.IBSJDBCUtil;
import sdn.sucredito.windcoin.ibs.jdbc.mapper.IBSDatosEntidadMapper;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSCuenta;
import sdn.sucredito.windcoin.ibs.jdbc.model.IBSDatosEntidad;
import sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas.impl.IBSConstants;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.*;

import static java.lang.System.out;
import static sdn.sucredito.windcoin.ibs.jdbc.procedures.cuentas.impl.IBSConstants.*;


public class IBSObtenerDatosEntidadStoredProcedureImpl extends StoredProcedure
    implements IBSObtenerDatosEntidadStoredProcedure {


    public static IBSDatosEntidadMapper mapper;
    static {
        mapper = new IBSDatosEntidadMapper();
    }

    private static final String PROCEDURE_NAME = "sdn_windcoin_entidad_datos";

    public IBSObtenerDatosEntidadStoredProcedureImpl(DataSource dataSource) {
        super(dataSource, PROCEDURE_NAME);
        setJdbcTemplate(new IBSJDBCTemplate(dataSource));
        setSql(PROCEDURE_NAME);

        declareParameter(new SqlParameter(NRODOC, Types.VARCHAR));
        declareParameter(new SqlParameter(CHECK_ONLY, Types.CHAR));
        declareParameter(new SqlOutParameter(STATUS, Types.INTEGER));
        compile();
        out.println("[windcoin-ibs] " + PROCEDURE_NAME + " compiled.");
    }


    @Override
    public Optional<IBSDatosEntidad> execute(String nrodoc) throws Exception {

        System.out.println("[windcoint-ibs] " + PROCEDURE_NAME + " execute with nrodoc: " + nrodoc);

        Map<String, Object> in = new HashMap<String, Object>();
        in.put(IBSConstants.NRODOC, nrodoc);
        in.put(IBSConstants.CHECK_ONLY, 'N');

        Map<String, Object> out = super.execute(in);
        ArrayList<LinkedCaseInsensitiveMap> resultSet = (ArrayList<LinkedCaseInsensitiveMap>)out.get("#result-set-1");
        System.out.println("[windcoin-ibs] " + PROCEDURE_NAME + " resulset is: ");
        System.out.println(TextTable.render(
                "Resulset #1",
                IBSJDBCUtil.toMap(resultSet.get(0))
        ));

        List<IBSCuenta> cuentas = new ArrayList<>();

        IBSDatosEntidad datosEntidad = mapper.map(resultSet.get(0));

        return Optional.of(datosEntidad);
    }
}
