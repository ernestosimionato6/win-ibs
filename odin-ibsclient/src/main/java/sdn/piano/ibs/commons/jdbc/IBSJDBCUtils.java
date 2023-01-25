package sdn.piano.ibs.commons.jdbc;

public final class IBSJDBCUtils {

public static String jdbcUrl(String host, String port, String database) {
	return "jdbc:sybase:Tds:"+host+":"+port+"/"+database+"?IS_CLOSED_TEST=select 1";
}

}
