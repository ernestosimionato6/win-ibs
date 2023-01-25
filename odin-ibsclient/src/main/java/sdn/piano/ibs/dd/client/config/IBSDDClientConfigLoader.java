package sdn.piano.ibs.dd.client.config;

import java.util.Properties;
import sdn.piano.ibs.dd.client.config.IBSDDClientConfig;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

import java.util.stream.*;

import static sdn.util.SdnPropertiesLoader.*; 
import static sdn.util.SdnObjectMapperReflection.convert;
import static sdn.lang.text.TextTable.render;

@Slf4j 
public class IBSDDClientConfigLoader {

public static String HOST = "ibs.host";
public static String PORT = "ibs.port";
public static String DATABASE = "ibs.database";
public static String USERNAME = "ibs.username";
public static String PASSWORD = "ibs.password";
public static String ENTIDAD_COD = "ibs.entidadcodpar";
public static String ENTIDAD_PASSW  = "ibs.entidadpasswpar";
public static String PAIS = "ibs.paiscod";
public static String BCO = "ibs.bcocod";
public static String SUC = "ibs.succod";
public static String TIPO_DOC = "ibs.tipdoc";
public static String USR_ID = "ibs.usrident";
public static String TER = "ibs.tercod";
public static String ORIG_PAIS = "ibs.origpaiscod";
public static String ORIG_BCO = "ibs.origbcocod";
public static String ORIG_SUC = "ibs.origsuccod";
public static String CONCEPTO = "ibs.concepto";
public static String TIPO_PRINT = "ibs.tipoPrint";

public static String TERMINALES = "ibs.terminales";
public static String TERMINAL_TOKEN = ",";
public static String INITIAL_POOL_SIZE = "ibs.initial_pool_size";

public static IBSDDClientConfig loadConfig(String resourceFileName) 
throws Exception {

log.trace("loading ibs_dd_client_config from {}.", resourceFileName); 

Properties props = loadProperties(resourceFileName);
log.trace("properties loaded. \n {}", props); 

IBSDDClientConfig config = IBSDDClientConfig.builder()
.host(props.getProperty(HOST))
.port(props.getProperty(PORT))
.database(props.getProperty(DATABASE))
.username(props.getProperty(USERNAME))
.password(props.getProperty(PASSWORD))
.entidadcodpar(Integer.valueOf(props.getProperty(ENTIDAD_COD)))
.entidadpasswpar(props.getProperty(ENTIDAD_PASSW))
.paiscod(Integer.valueOf(props.getProperty(PAIS)))
.bcocod(Integer.valueOf(props.getProperty(BCO)))
.succod(Integer.valueOf(props.getProperty(SUC)))
.tipdoc(Integer.valueOf(props.getProperty(TIPO_DOC)))
.usrident(Integer.valueOf(props.getProperty(USR_ID)))
.tercod(Integer.valueOf(props.getProperty(TER)))
.origpaiscod(Integer.valueOf(props.getProperty(ORIG_PAIS)))
.origbcocod(Integer.valueOf(props.getProperty(ORIG_BCO)))
.origsuccod(Integer.valueOf(props.getProperty(ORIG_SUC)))
.concepto(props.getProperty(CONCEPTO))
.tipoPrint(Integer.valueOf(props.getProperty(TIPO_PRINT)))
.terminales(
	Arrays.asList(props.getProperty(TERMINALES).split(TERMINAL_TOKEN))
	.stream()
	.map(t -> Integer.valueOf(t))
	.collect(Collectors.toList())
)
.initialPoolSize(Integer.valueOf(props.getProperty(INITIAL_POOL_SIZE)))
.build();
log.trace("ibs_dd_client_config loaded from {}. \n {}",
	resourceFileName,
	render("IBSDD_CONFIGURATION", convert(config))
); 

return config;
}

public static void main(String args[]) throws Exception {
   System.out.println("..... ibs_dd_client_config main[] of " + args[0]);
   System.out.println(loadConfig(args[0]));
}

}
