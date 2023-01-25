package sdn.util;

import org.springframework.util.LinkedCaseInsensitiveMap;
import java.util.*;
import java.util.stream.*;

public class SdnMaps {

@SuppressWarnings({"unchecked", "deprecated"})
public static Map<String, Object> toMap(LinkedCaseInsensitiveMap rs) {
 Map<String, Object> props = new HashMap<String, Object>();
 System.out.println(rs.getClass()); 
 rs.keySet().stream().forEach(k -> {
	props.put(k.toString(), rs.get(k));
 }); 
 return props;
}

}
