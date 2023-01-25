package sdn.piano.ibs.ssg.jdbc.mapper;

import java.util.*;
import java.math.*;
import sdn.piano.ibs.ssg.jdbc.model.*;

import static sdn.piano.ibs.ssg.jdbc.SSGConstants.*;

public class SSGUsrCredentialsMapper {
   public Map<String, Object> map(SSGUsrCredentials credentials) throws Exception {
	Map<String, Object> m = new HashMap<String, Object>();
	m.put(ENTIDADCODPAR, new BigDecimal(credentials.entidadcodpar));
	m.put(ENTIDADPASSWPAR, credentials.entidadpasswpar);
	m.put(PAISCOD, new BigDecimal(credentials.paiscod));
	m.put(BCOCOD, new BigDecimal(credentials.bcocod));
	m.put(SUCCOD, new BigDecimal(credentials.succod));
	m.put(TIPDOC, new BigDecimal(credentials.tipdoc));
	m.put(USRIDENT, new BigDecimal(credentials.usrident));
	m.put(TERCOD, new BigDecimal(credentials.tercod));
	m.put(ORIGPAISCOD, new BigDecimal(credentials.origpaiscod));
	m.put(ORIGBCOCOD, new BigDecimal(credentials.origbcocod));
	m.put(ORIGSUCCOD, new BigDecimal(credentials.origsuccod));
	// m.put(CONCEPTO, "" + credentials.concepto);
	// m.put(TIPO_PRINT, new BigDecimal(credentials.tipoPrint));
 	return m;	
   }
}
