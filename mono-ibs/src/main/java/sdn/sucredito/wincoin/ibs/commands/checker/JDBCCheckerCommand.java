package sdn.sucredito.wincoin.ibs.commands.checker;

import sdn.sucredito.wincoin.ibs.jdbc.checker.ChechResult;
import sdn.sucredito.wincoin.ibs.jdbc.checker.ConnectionParameters;
import sdn.sucredito.wincoin.ibs.jdbc.checker.ConnectorChecker;
import sdn.sucredito.wincoin.ibs.jdbc.checker.sysbase.SysbaseChecker;

import java.util.HashMap;
import java.util.Map;

import static java.lang.System.out;

public class JDBCCheckerCommand {


    /**
        [
             host = 172.17.21.5,
             port = 5000,
             database/schema = Banksys,
             username = softdlenoa,
             password =
        ]
    **/
    public static void main(String args[]) throws Exception {
        String connectionUrl = args[0];
        String username = args[1];
        String password = args[2];

        out.println("[windcoing-ibs] jdbc-connection-checker..............");

        ConnectionParameters connectionParams = ConnectionParameters.builder()
                .connectionUrl(connectionUrl)
                .user(username)
                .password(password)
                .build();
        out.println("[wincoin-ibs] checking connection of " + connectionParams);

        ConnectorChecker checker = new SysbaseChecker();
        ChechResult result = checker.check(connectionParams);

        out.print("[wincoin-ibs] result is " + result);
    }
}
