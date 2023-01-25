package sdn.sucredito.windcoin.ibs.client.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static java.lang.System.out;

public class IBSConfigurationPropertiesLoader {

    private static final String CONNECTION_URL = "ibs.connection_url";
    private static final String USERNAME = "ibs.username";

    private static final String PASSWORD = "ibs.password";

    public static Properties load(String filePath) {

        Properties prop = new Properties();

        try (InputStream input = new FileInputStream(filePath)) {

            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return prop;
    }

    public static IBSConfigurationProperties loadIBSProperties(String filePath) {
        Properties props = load(filePath);
        return IBSConfigurationProperties.builder()
                .connectionUrl(props.getProperty(CONNECTION_URL))
                .username(props.getProperty(USERNAME))
                .password(props.getProperty(PASSWORD))
                .build();
    }

    public static void main(String args[]) throws Exception {
        out.println("properties loaded. "  + loadIBSProperties("./ibs_windcoin.properties"));
    }
}
