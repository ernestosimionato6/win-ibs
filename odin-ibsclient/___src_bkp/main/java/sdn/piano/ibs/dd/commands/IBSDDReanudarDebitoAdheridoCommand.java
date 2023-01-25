package sdn.piano.ibs.dd.commands;

import java.util.*;

import sdn.lang.text.TextTable;
import sdn.piano.ibs.IBSAbstractCommand;
import sdn.piano.ibs.dd.domain.*;
import sdn.piano.ibs.dd.client.*;
import sdn.piano.ibs.dd.client.impl.*;
import sdn.piano.ibs.dd.client.request.*;
import sdn.piano.ibs.dd.client.response.*;

import static sdn.piano.ibs.dd.client.config.IBSDDClientConfigLoader.loadConfig;

public class IBSDDReanudarDebitoAdheridoCommand {

IBSDDClient client;

public IBSDDReanudarDebitoAdheridoCommand(IBSDDClient client) {
  this.client = client;
}

public Optional<Tramite> reanudarDebitoAdherido(String tipoCuenta, String nroCuenta, String idAdhesion) throws Exception {
  return Optional.of(client.reanudarDebitoAdherido(
	IBSDDReanudarDebitoAdheridoRequest.of(idAdhesion)	
  ).tramite); 
}

public static void main(String args[]) throws Exception {
 if(args.length<2) throw new RuntimeException("debe informar el id de adhesion y la cuenta asociada.  \n" + HELP);
 String tipoCuenta = args[1]; String nroCuenta = args[2]; String idAdhesion = args[0];

 System.out.println("..................... ibs_reanudar_debito_adherido " + idAdhesion + " .... " + nroCuenta + " ..... " + tipoCuenta);

 IBSDDReanudarDebitoAdheridoCommand ctx = new IBSDDReanudarDebitoAdheridoCommand(new IBSDDClientImpl(
    loadConfig("ibs_config.properties")
 ));

 Optional<Tramite> tramite = ctx.reanudarDebitoAdherido(tipoCuenta, nroCuenta, idAdhesion);
 System.out.println("tramite realizado. " + tramite);

}


public static String HELP = "\n " +
"Usage: sdn_ibs_dd reanudar_debito_adherido <id_adhesion> <tipo_cuenta> <nro_cuenta> \n\n" +
"       nro_adhesion     :  nro interno de la adhesion que se genera al momento de realizar la adhesion.\n" +
"                          Esta adhesion se da atraves de Operatoria/Deibtios Directos/Interaccion con Cliente/Adm.\n" +
"                          Estas adesiones tambien se gestionan por el vuelco en el archivo PP)ddmm.301.\n" +
"                          eg: $ abcd \n" +
"       tipo_cuenta     :  tipo de cuenta en ibs. [ 11: cuenta_corriente, 01: caja de ahorro ]\n" +
"                          eg: 11 \n"+ 
"	nro_cuenta      :  nro de cuenta en ibs. \n" +
"                          eg: 12342341234 \n" +
"";


}
