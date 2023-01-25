package sdn.sucredito.windcoin.ibs.jdbc.checker;

public interface ConnectorChecker {

    ChechResult check(ConnectionParameters parameters);
}
