package sdn.sucredito.wincoin.ibs.jdbc.checker;

import org.postgresql.Driver;


import java.sql.DriverManager;

import static java.lang.System.out;

public class JdbcChecker implements ConnectorChecker {


    static {
        try {
            DriverManager.registerDriver(new Driver());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public ChechResult check(ConnectionParameters parameters) {
        out.println("[INFO] checking connection [JDBC] of " + parameters);

        // out.println("[INFO] registering a connection class [JDBC] of " + parameters.getClassName());
        // try {
        //     DriverManager.registerDriver(forName(parameters.getClassName()));
        // } catch (Exception e) {
        //     throw new RuntimeException(e);
        // }
        out.println("[INFO] checking connection [JDBC] of " + parameters);



        // String connectionUrl = "jdbc:sqlserver://<server>:<port>;encrypt=true;databaseName=AdventureWorks;user=<user>;password=<password>";
        try {
            DriverManager.getConnection(parameters.getConnectionUrl(), parameters.getUser(), parameters.getPassword());
        } catch (Exception e) {
           out.println("[ERROR] connection [JDBC] not resolved.");
           out.println(e);
           return ChechResult.builder().success(false).errorMessage(e.getMessage()).build();
        }
        out.println("[OK] connection [JDBC] succesfull resolved.");
        return ChechResult.builder().success(true).build();
    }

}
