package sdn.sucredito.windcoin.ibs.client.config;

import sdn.sucredito.windcoin.ibs.jdbc.IBSConnection;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;

import java.sql.SQLException;

public interface IBSConfiguration {

    public IBSConfigurationProperties properties();
    public IBSConnectionPool pool(IBSConfigurationProperties properties);

    public IBSConnection connection(IBSConnectionPool pool) throws SQLException;

}
