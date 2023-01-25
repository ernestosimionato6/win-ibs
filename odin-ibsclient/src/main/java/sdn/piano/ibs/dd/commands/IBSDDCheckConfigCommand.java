package sdn.piano.ibs.dd.commands;

import java.util.*;

import sdn.lang.text.TextTable;
import sdn.piano.ibs.dd.client.config.*;

import static sdn.util.SdnObjectMapperReflection.convert;
import static sdn.piano.ibs.dd.client.config.IBSDDClientConfigLoader.loadConfig;
import static sdn.lang.text.TextTable.render;

public class IBSDDCheckConfigCommand {

public static void main(String args[]) throws Exception {
if(args.length<1) throw new RuntimeException("debe definir el archivo de configuracion.");
String configPath = args[0];
System.out.println("......................... ibs_check_configuracion " + configPath);
IBSDDClientConfig config = loadConfig(configPath);
System.out.println(" > la configuracion cargada es : \n" + render("IBS_CONFIG", convert(config)));
}

}
