package sdn.sucredito.windcoin.ibs.commands.checker;

import sdn.sucredito.windcoin.ibs.jdbc.checker.ChechResult;
import sdn.sucredito.windcoin.ibs.jdbc.checker.ConnectionParameters;
import sdn.sucredito.windcoin.ibs.jdbc.checker.ConnectorChecker;
import sdn.sucredito.windcoin.ibs.jdbc.checker.sysbase.SysbaseChecker;

import static java.lang.System.out;

public class JDBCCheckerCommand {

    public static String jdbcUrl(String host, String port, String database) {
        return "jdbc:sybase:Tds:"+host+":"+port+"/"+database+"?IS_CLOSED_TEST=select 1";
    }

    /**
        [
             host = 172.17.21.5,
             port = 5000,
             database/schema = Banksys,
             username = softdlenoa,
             password =
        ]
        Main:
            ID : sysbase_jconn
            name : Banksys
        Server:
            Address: 172.17.21.5:5000
            Database: Banksys
            URL: jdbc:sybase:Tds:172.17.21.5:5000?ServiceName=Banksys
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
