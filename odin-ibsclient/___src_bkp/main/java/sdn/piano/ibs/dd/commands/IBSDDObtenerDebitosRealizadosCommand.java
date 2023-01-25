package sdn.piano.ibs.dd.commands;

import java.util.*;
import sdn.lang.text.TextTable;

import sdn.piano.ibs.IBSAbstractCommand;

import sdn.piano.ibs.dd.domain.DebitoRealizado;

import sdn.piano.ibs.dd.client.IBSDDClient;
import sdn.piano.ibs.dd.client.impl.IBSDDClientImpl;
import sdn.piano.ibs.dd.client.request.*;
import sdn.piano.ibs.dd.client.response.*;

import static sdn.piano.ibs.dd.client.config.IBSDDClientConfigLoader.loadConfig;

public class IBSDDObtenerDebitosRealizadosCommand { 

IBSDDClient client;

public IBSDDObtenerDebitosRealizadosCommand(IBSDDClient client) {
 this.client = client;
}

public List<DebitoRealizado> obtenerDebitosRealizados(String tipoCuenta, String nroCuenta) throws Exception {
  return client.obtenerDebitosRealizados(
	IBSDDObtenerDebitosRealizadosRequest.of(tipoCuenta, nroCuenta)
  ).debitosRealizados;
}

public static void main(String args[]) throws Exception {
 if(args.length<2) throw new RuntimeException("debe definir el nro de cuenta y su tipo");
 String tipoCuenta = args[0]; String nroCuenta = args[1];
 System.out.println("..................... ibs_obtener_debitos_realizados of " + nroCuenta + " ..... " + tipoCuenta);

 IBSDDObtenerDebitosRealizadosCommand ctx = new IBSDDObtenerDebitosRealizadosCommand(new IBSDDClientImpl( 
     loadConfig("ibs_config.properties")		
 ));

 List<DebitoRealizado> debitosRealizados = ctx.obtenerDebitosRealizados(tipoCuenta, nroCuenta);
 ctx.printDebitosRealizados(debitosRealizados);

}


private void printDebitosRealizados(List<DebitoRealizado> debitosRealizados) {
  TextTable table = new TextTable("Debitos Realizados", 10);
  table.columnHeaders(
	"nroComprobante", 
	"nombreEmpresa",
	"concepto",
	"idCliente",
	"fechaVencimiento",
	"monto",
	"moneda",
	"cuenta",
	"referencia",
	"estadoDebito"
   );
   debitosRealizados.stream().forEach(d -> {
	table.center(
		d.nroComprobante,
		d.nombreEmpresa,
		d.concepto,
		d.idCliente,
		d.fechaVencimiento,
		d.monto,
		d.moneda,
		d.cuenta,
		d.referencia,
		d.estadoDebito
	);
   });
   System.out.println(table.sm().render());

}
}
