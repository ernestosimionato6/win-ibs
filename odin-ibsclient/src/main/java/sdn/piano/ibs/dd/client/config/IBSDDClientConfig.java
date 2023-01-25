package sdn.piano.ibs.dd.client.config;

import sdn.piano.ibs.ssg.jdbc.model.SSGUsrCredentials;

import lombok.*;

import java.util.*;

@Data
@ToString
@Builder
@AllArgsConstructor
public class IBSDDClientConfig {

public String host;
public String port;
public String database;
public String username;
public String password;

public Integer entidadcodpar;
public String entidadpasswpar;
public Integer paiscod;
public Integer bcocod;
public Integer succod;
public Integer tipdoc;
public Integer usrident;
public Integer tercod;
public Integer origpaiscod;
public Integer origbcocod;
public Integer origsuccod;
public String concepto;
public Integer tipoPrint;

public List<Integer> terminales;
public Integer initialPoolSize;

}
