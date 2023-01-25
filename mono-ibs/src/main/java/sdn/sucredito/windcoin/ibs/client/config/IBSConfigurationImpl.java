package sdn.sucredito.windcoin.ibs.client.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import sdn.sucredito.windcoin.ibs.jdbc.IBSBasicConnectionPool;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnection;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;

import java.sql.SQLException;

@Data
@AllArgsConstructor
@ToString
@Builder
public class IBSConfigurationImpl
    implements IBSConfiguration {

    IBSConfigurationProperties properties;


    public IBSConfigurationProperties properties() {
        return this.properties;
    }

    public IBSConnectionPool pool(
           IBSConfigurationProperties properties
    ) {
       return new IBSBasicConnectionPool(
               properties.connectionUrl,
               properties.username,
               properties.password
       );
    }

    public IBSConnection connection(
            IBSConnectionPool pool
    ) throws SQLException {
        return pool.getIBSConnection();
    }

}
