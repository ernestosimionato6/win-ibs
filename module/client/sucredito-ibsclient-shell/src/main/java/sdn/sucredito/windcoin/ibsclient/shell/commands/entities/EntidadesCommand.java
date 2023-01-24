package sdn.sucredito.windcoin.ibsclient.shell.commands.entities;

import picocli.CommandLine;

import static java.lang.System.out;

@CommandLine.Command(
        name = "entidad"
)
public
class EntidadesCommand implements  Runnable {

    @Override
    public void run() {
        out.println("[entidades command]");
    }
}
