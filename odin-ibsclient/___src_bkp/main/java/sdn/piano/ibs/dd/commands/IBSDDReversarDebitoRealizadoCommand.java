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

public class IBSDDReversarDebitoRealizadoCommand {

IBSDDClient client;

public IBSDDReversarDebitoRealizadoCommand(IBSDDClient client) {
  this.client = client;
}

public Optional<Tramite> reversarDebitoRealizado(String tipoCuenta, String nroCuenta, String id) throws Exception {
  return Optional.of(client.reversarDebitoRealizado(
	IBSDDReversarDebitoRealizadoRequest.of(id)	
  ).tramite); 
}

public static void main(String args[]) throws Exception {
 if(args.length<2) throw new RuntimeException("debe informar el id y la cuenta asociada.  \n" + HELP);
 String tipoCuenta = args[0]; String nroCuenta = args[1]; String id = args[2];

 System.out.println("..................... ibs_reversar_debito_realizado " + id + " .... " + nroCuenta + " ..... " + tipoCuenta);

 IBSDDReversarDebitoRealizadoCommand ctx = new IBSDDReversarDebitoRealizadoCommand(new IBSDDClientImpl(
    loadConfig("ibs_config.properties")
 ));

 Optional<Tramite> tramite = ctx.reversarDebitoRealizado(tipoCuenta, nroCuenta, id);
 System.out.println("tramite realizado. " + tramite);

}


public static String HELP = "\n " +
"Usage: sdn_ibs_dd reversar_debito_realizado <id> <tipo_cuenta> <nro_cuenta> \n\n" +
"       nro     :  nro interno del debito que se genera al momento de realizarlo.\n" +
"                          Este debito se da atraves de Operatoria/Deibtios Directos/Interaccion con Cliente/Adm.\n" +
"                          Estas adesiones tambien se gestionan por el vuelco en el archivo PP)ddmm.301.\n" +
"                          eg: $ abcd \n" +
"       tipo_cuenta     :  tipo de cuenta en ibs. [ 11: cuenta_corriente, 01: caja de ahorro ]\n" +
"                          eg: 11 \n"+ 
"	nro_cuenta      :  nro de cuenta en ibs. \n" +
"                          eg: 12342341234 \n" +
"";


}
