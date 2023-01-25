package sdn.sucredito.windcoin.ibs.ssg.jdbc.model;

import lombok.*;
import java.util.*;

@Data
@ToString
@Builder
@AllArgsConstructor
public class SSGUsrCredentials {

public Integer entidadcodpar;
public String entidadpasswpar;
public Integer paiscod;
public Integer bcocod;
public Integer succod;
public Integer tipdoc;
public Integer usrident;
@With
public Integer tercod;
public Integer origpaiscod;
public Integer origbcocod;
public Integer origsuccod;
public String concepto;
public Integer tipoPrint;

public static SSGUsrCredentials DEFAULT;

static {
DEFAULT = SSGUsrCredentials.builder()
	.entidadcodpar(1057)
	.entidadpasswpar("PSW CENSYS")
	.paiscod(54)
	.bcocod(301)
	.succod(1)
	.tipdoc(88)
	.usrident(2000001)
        .tercod(17680)
	.origpaiscod(54)
	.origbcocod(301)
	.origsuccod(1)
	.concepto("H2H")
	.tipoPrint(0)
	.build();	
}

}
