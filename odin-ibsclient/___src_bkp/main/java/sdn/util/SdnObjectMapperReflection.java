package sdn.util;

import java.util.*;
import java.lang.reflect.*;

public class SdnObjectMapperReflection {

public static Map<String, Object> convert(Object o) throws Exception {
  System.out.println("@@@ mapping fields of " + o);

  Map<String, Object> mapOfFields = new HashMap<String, Object>(); 
  Field[] allFields = o.getClass().getDeclaredFields();

  for (Field field : allFields) {
     field.setAccessible(true);
     Object value = field.get(o);
     mapOfFields.put(field.getName(), value);
  }

  return mapOfFields;
}

}
