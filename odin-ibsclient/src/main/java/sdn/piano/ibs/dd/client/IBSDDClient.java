package sdn.piano.ibs.dd.client;

import sdn.piano.ibs.dd.client.request.*;
import sdn.piano.ibs.dd.client.response.*;

public interface IBSDDClient {

public IBSDDObtenerDebitosAdheridosResponse obtenerDebitosAdheridos(IBSDDObtenerDebitosAdheridosRequest request)
   throws Exception;
public IBSDDObtenerDebitosRealizadosResponse obtenerDebitosRealizados(IBSDDObtenerDebitosRealizadosRequest request)
   throws Exception;

public IBSDDPausarDebitoAdheridoResponse pausarDebitoAdherido(IBSDDPausarDebitoAdheridoRequest request) throws Exception;

public IBSDDBajarDebitoAdheridoResponse bajarDebitoAdherido(IBSDDBajarDebitoAdheridoRequest request) throws Exception;

public IBSDDReanudarDebitoAdheridoResponse reanudarDebitoAdherido(IBSDDReanudarDebitoAdheridoRequest request) throws Exception;

public IBSDDReversarDebitoRealizadoResponse reversarDebitoRealizado(IBSDDReversarDebitoRealizadoRequest request) throws Exception;


}
