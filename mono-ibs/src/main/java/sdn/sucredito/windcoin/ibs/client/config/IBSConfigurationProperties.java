package sdn.sucredito.windcoin.ibs.client.config;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static com.sybase.jdbcx.SybDataSource.PASSWORD;
import static org.postgresql.shaded.com.ongres.scram.common.ScramAttributes.USERNAME;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "ibs")
public class IBSConfigurationProperties {

    String username;
    String password;
    String connectionUrl;

    Integer initialPoolSize;
    Integer maxPoolSize;
    Integer maxTimeout;

}


