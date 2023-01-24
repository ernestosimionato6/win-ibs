package sdn.sucredito.windcoin.ibsclient.shell

import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class IbsCliApplication

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}