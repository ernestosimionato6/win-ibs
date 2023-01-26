package sdn.sucredito.windcoin.ibs.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;
import sdn.sucredito.wincoin.model.Cuit;
import sdn.sucredito.wincoin.model.cuenta.Cuenta;
import sdn.sucredito.wincoin.model.entidad.DatosEntidad;
import sdn.sucredito.wincoin.model.entidad.Representante;
import sdn.sucredito.windcoin.ibs.client.WincoinClientIBS;
import sdn.sucredito.windcoin.ibs.client.config.IBSConfiguration;
import sdn.sucredito.windcoin.ibs.client.config.IBSConfigurationImpl;
import sdn.sucredito.windcoin.ibs.client.config.IBSConfigurationProperties;
import sdn.sucredito.windcoin.ibs.client.impl.WincoinClientIBSImpl;
import sdn.sucredito.windcoin.ibs.jdbc.IBSBasicConnectionPool;
import sdn.sucredito.windcoin.ibs.jdbc.IBSConnectionPool;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static sdn.sucredito.windcoin.ibs.client.config.IBSConfigurationPropertiesLoader.loadIBSProperties;


interface WincoinIBSCommand {

        void obtenerDatosEntidad(
                String cuitEntidad
        ) throws Exception;

        @Command(
                name = "obtener-representantes",
                description = "Muestra los representantes de una persona juridica."
        )
        void obtenerRepresentantes(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad
        ) throws Exception;

        @Command(
                name = "obtener-apoderados",
                description = "Muestra los apoderados de una persona juridica."
        )
        void obtenerApoderados(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad
        ) throws Exception;

        @Command(
                name = "obtener-cuentas",
                description = "Muestra las cuentas de una persona juridica."
        )
        void obtenerCuentas(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad,
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_representante>",
                        description = "CUIT de un representante de la entidad (persona juridica)"
                ) String cuitRepresentante
        ) throws Exception;
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
        ) throws Exception {
                System.out.println("  [ obtener_datos_entidad  ] of " + cuitEntidad);
                Optional<DatosEntidad> datosEntidad =  client.obtenerDatosEntidad(Cuit.of(cuitEntidad));
                System.out.println(" [ entidad-" + cuitEntidad + " ] "  + datosEntidad);
        }



        @Override
        @Command(
                name = "obtener-representantes",
                description = "Muestra los representantes de una persona juridica."
        )
        public void obtenerRepresentantes(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad
        ) throws Exception {
                System.out.println("  [ obtener_representantes  ] of " + cuitEntidad);
                List<Representante> representantes =  client.obtenerRepresentantes(Cuit.of(cuitEntidad));
                System.out.println(" [ entidad-" + cuitEntidad + " ] "  + representantes);
        }


        @Override
        @Command(
                name = "obtener-apoderados",
                description = "Muestra los apoderados de una persona juridica."
        )
        public void obtenerApoderados(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad
        ) throws Exception {
                System.out.println("  [ obtener_apoderados  ] of " + cuitEntidad);
                List<Representante> apoderados =  client.obtenerApoderados(Cuit.of(cuitEntidad));
                System.out.println(" [ entidad-" + cuitEntidad + " ] "  + apoderados);
        }

        @Override
        @Command(
                name = "obtener-cuentas",
                description = "Muestra las cuentas de una persona juridica."
        )
        public void obtenerCuentas(
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_entidad>",
                        description = "CUIT de la entidad (persona juridica)"
                ) String cuitEntidad,
                @Parameters(
                        arity = "1",
                        paramLabel = "<cuit_representante>",
                        description = "CUIT de un representante de la entidad (persona juridica)"
                ) String cuitRepresentante
        ) throws Exception {
                System.out.println("  [ obtener_cuentas  ] of cuit_entidad: " + cuitEntidad + ", cuit_representante: " + cuitRepresentante);
                List<Cuenta> cuentas =  client.obtenerCuentas(Cuit.of(cuitEntidad), Cuit.of(cuitRepresentante));
                System.out.println(" [ entidad-" + cuitEntidad + " | representante-" + cuitRepresentante + " ] "  + cuentas);
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
