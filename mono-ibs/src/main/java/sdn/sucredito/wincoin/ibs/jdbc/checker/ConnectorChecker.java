package sdn.sucredito.wincoin.ibs.jdbc.checker;

public interface ConnectorChecker {

    ChechResult check(ConnectionParameters parameters);
}
