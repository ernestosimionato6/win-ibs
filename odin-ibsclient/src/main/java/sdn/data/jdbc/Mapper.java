package sdn.data.jdbc;

import java.util.*;

public interface Mapper<T> {

  public T map(Map<String, Object> row) throws Exception;

}
