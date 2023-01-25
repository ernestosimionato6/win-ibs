package sdn.sucredito.windcoin.ibs.jdbc;

import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.HashMap;
import java.util.Map;

public class IBSJDBCUtil {


    public static  Map<String, Object> toMap(LinkedCaseInsensitiveMap rs) {
        Map<String, Object> props = new HashMap<String, Object>();
        System.out.println(rs.getClass());
        rs.keySet().stream().forEach(k -> {
            props.put(k.toString(), rs.get(k));
        });
        return props;
    }

}
