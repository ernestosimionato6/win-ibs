package sdn.sucredito.windcoin.ibs.commands;

import picocli.CommandLine.IVersionProvider;

import java.io.BufferedInputStream;
import java.io.InputStream;

public class WincoinIBSVersionProvider  implements IVersionProvider {


    @Override
    public String[] getVersion() throws Exception {
        // InputStream input = WincoinIBSVersionProvider.class.getResourceAsStream("/version.txt");
        return new String[] { "sucredito-windcoin v1.0.1" };
    }
}
