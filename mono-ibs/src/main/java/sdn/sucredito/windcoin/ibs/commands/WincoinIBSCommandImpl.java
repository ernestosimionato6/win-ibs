package sdn.sucredito.windcoin.ibs.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;
import sdn.sucredito.windcoin.ibs.client.WincoinClientIBS;
import sdn.sucredito.windcoin.ibs.client.config.IBSConfiguration;
import sdn.sucredito.windcoin.ibs.client.config.IBSConfigurationImpl;
import sdn.sucredito.windcoin.ibs.client.config.IBSConfigurationProperties;
import sdn.sucredito.windcoin.ibs.client.impl.WincoinClientIBSImpl;
import sdn.sucredito.windcoin.ibs.jdbc.IBSBasicConnectionPool;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;

import java.sql.SQLException;

import static sdn.sucredito.windcoin.ibs.client.config.IBSConfigurationPropertiesLoader.loadIBSProperties;


interface WincoinIBSCommand {

        void obtenerDatosEntidad(
                String cuitEntidad
        );
}

@Data
@AllArgsConstructor
@Command(
        name = "ibs-client",
        subcommands = {
                CommandLine.HelpCommand.class,

        },
        description = "Mustra informacion acerca de la ENTIDADES.",
        versionProvider = WincoinIBSVersionProvider.class
)
public class WincoinIBSCommandImpl implements WincoinIBSCommand, Runnable {

        private static final String IBS_WINDCOIN_PROPERTIES_FILE = "ibs_windcoin.properties";

        WincoinClientIBS client;
        @Spec CommandSpec spec;

        public WincoinIBSCommandImpl(WincoinClientIBS client) {
                this.client = client;
        }


        @Override
        @Command(
                name = "obtener-datos-entidad",
                description = "Muestra los datos de una persona juridica."
        )
        public void obtenerDatosEntidad(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad
        ) {
                System.out.println("[obtener_datos_entidad] of " + cuitEntidad);
        }

        @Override
        public void run() {
                throw new ParameterException(
                        spec.commandLine(),
                        "Especifique una operacion."
                );
        }


        public static void main(String[] args) throws SQLException {
                IBSConfigurationProperties properties =
                        loadIBSProperties(IBS_WINDCOIN_PROPERTIES_FILE);
                IBSConfiguration configuration = new IBSConfigurationImpl(properties);
                IBSConnectionPool pool = IBSBasicConnectionPool.create(
                        properties.getConnectionUrl(),
                        properties.getUsername(),
                        properties.getPassword(),
                        properties.getInitialPoolSize(),
                        properties.getMaxPoolSize(),
                        properties.getMaxTimeout()
                );
                WincoinClientIBS client = new WincoinClientIBSImpl(pool);
               CommandLine cmd = new CommandLine(new WincoinIBSCommandImpl(client));
               if (args.length == 0) {
                       cmd.usage(System.out);
               } else {
                       cmd.execute(args);
               }
               client.shutdown();
        }
}
