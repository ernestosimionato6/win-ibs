package sdn.sucredito.wincoin.ibs.jdbc.checker.sysbase;


import sdn.sucredito.wincoin.ibs.jdbc.checker.ChechResult;
import sdn.sucredito.wincoin.ibs.jdbc.checker.ConnectionParameters;
import sdn.sucredito.wincoin.ibs.jdbc.checker.ConnectorChecker;

import java.sql.DriverManager;

import static java.lang.System.out;

public class SysbaseChecker implements ConnectorChecker {

    static {
        try {
            DriverManager.registerDriver(new com.sybase.jdbc4.jdbc.SybDriver());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ChechResult check(ConnectionParameters parameters) {

        out.println("[INFO] checking connection [SYSBASE] of " + parameters);
        // String connectionUrl =  "jdbc:sybase:Tds:"+host+":"+port+"/"+database+";IS_CLOSED_TEST=select 1";
        try {
            DriverManager.getConnection(
									 parameters.getConnectionUrl(),
									 parameters.getUser(),
									 parameters.getPassword()
									 );
        } catch (Exception e) {
           out.println("[ERROR] connection [SYSBASE] not resolved.");
           out.println(e);
           return ChechResult.builder().success(false).errorMessage(e.getMessage()).build();
        }
        out.println("[OK] connection [SYSBASE] succesfull resolved.");
        return ChechResult.builder().success(true).build();
    }
}
