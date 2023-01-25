package sdn.piano.ibs.dd.service;

import java.util.*;

import sdn.piano.ibs.dd.domain.*;

public interface IBSDDManaService {

public Tramite pausarDebitoAdherido(String idAdhesion) throws Exception; 
public Tramite bajarDebitoAdherido(String idAdhesion) throws Exception; 
public Tramite reanudarDebitoAdherido(String idAdhesion) throws Exception; 
public Tramite reversarDebitoRealizado(String id) throws Exception; 

}
