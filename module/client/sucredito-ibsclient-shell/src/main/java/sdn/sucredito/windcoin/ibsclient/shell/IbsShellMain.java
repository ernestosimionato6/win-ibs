package sdn.sucredito.windcoin.ibsclient.shell;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import sdn.sucredito.windcoin.ibsclient.shell.commands.entities.EntidadesCommand;

import static java.lang.System.out;

@Command(
        name = "sucredito", mixinStandardHelpOptions = true,
        subcommands = {
                EntidadesCommand.class
//        TaskCommand::class,
//        TrackCommand::class,
//        LogCommand::class,
//        ReportCommand::class,
//        TagCommand::class,
//        AlfredCommand::class,
        }
)
public class IbsShellMain implements Runnable {
    @Option(names = "--interactive", interactive = true)
    String value;

    public void run() {
 //       if (value == null && System.console() != null) {
 //           // alternatively, use Console::readPassword
 //           value = System.console().readLine("Enter value for --interactive: ");
 //       }
 //       System.out.println("You provided value '" + value + "'");
    }

    public static void main(String[] args) {
//        out.println("[sucredito-windcoint-ibsshell]");
        new CommandLine(new IbsShellMain()).execute(args);
    }
}