package sdn.piano.ibs.dd.commands;

import java.util.*;
import sdn.lang.text.TextTable; 
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciitable.AT_Row;
import de.vandermeer.skb.interfaces.transformers.textformat.TextAlignment;

import sdn.piano.ibs.dd.domain.*;

import sdn.piano.ibs.IBSAbstractCommand;

import sdn.piano.ibs.dd.repository.impl.*;
import sdn.piano.ibs.dd.repository.*;

public class IBSDDObtenerDebitosAdheridosCommand extends IBSAbstractCommand {

public IBSDebitosAdheridosRepository debitosAdheridosRepository; 

@Override
public void bootstrap() throws Exception {
  super.bootstrap();
  debitosAdheridosRepository = new IBSDebitosAdheridosRepositoryImpl(this.pool);
}

public List<DebitoAdherido> obtenerDebitosAdheridos(String tipoCuenta, String nroCuenta) throws Exception  {
   return debitosAdheridosRepository.obtenerDebitosAdheridos(tipoCuenta, nroCuenta);
}


public static void main(String args[]) throws Exception {

	if(args.length<2) throw new RuntimeException("debe definir el nro de cuenta y su tipo");
	String tipoCuenta = args[0]; String nroCuenta = args[1];
	System.out.println("................. ibs_obtener_debitos_adheridos of " + nroCuenta + " ..... "+ tipoCuenta);

	IBSDDObtenerDebitosAdheridosCommand ctx = new IBSDDObtenerDebitosAdheridosCommand();
	ctx.bootstrap();

	List<DebitoAdherido> debitosAdheridos =  ctx.obtenerDebitosAdheridos(tipoCuenta, nroCuenta);
	ctx.printDebitosAdheridos(debitosAdheridos);

	ctx.down();
}

private void printDebitosAdheridos(List<DebitoAdherido> debitosAdheridos) {

	TextTable table = new TextTable("Debitos Adheridos", 10);
	table.columnHeaders( "nro_adhesion", "codigo_empresa", "concepto",
 	 		     "id_cliente" , "moneda", "fecha_adhesion",
			     "cuenta", "fecha_vencimiento", "monto",
			     "estado_adhesion" );
	debitosAdheridos.stream().forEach(debitoAdherido -> {
		table.center( 
			debitoAdherido.nroAdhesion,
			debitoAdherido.codigoEmpresa,
			debitoAdherido.concepto,
			debitoAdherido.idCliente,
			debitoAdherido.moneda,
			debitoAdherido.fechaAdhesion,
			debitoAdherido.cuenta,
			debitoAdherido.fechaVencimiento,
			debitoAdherido.monto,
			debitoAdherido.estadoAdhesion
		);
	});
	System.out.println(table.sm().render());
}

}
