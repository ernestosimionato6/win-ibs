package sdn.piano.ibs.commons.jdbc;

import org.springframework.jdbc.datasource.*;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.Set;
import java.util.logging.Logger;


public class SimpleDataSource implements DataSource, SmartDataSource {

@Override
public Connection getConnection() throws SQLException {
  throw new RuntimeException(".... not implemented yet!");
}

@Override
public Connection getConnection(final String username, final String password) throws SQLException {
  throw new RuntimeException("..... not implemented yet!");
}

@Override
public PrintWriter getLogWriter() throws SQLException {
  throw new RuntimeException("..... not implemented yet!");
}

@Override
public void setLogWriter(final PrintWriter out) throws SQLException {
throw new RuntimeException(".... not implemented yet!");
}

@Override
public void setLoginTimeout(final int seconds) throws SQLException {
throw new RuntimeException(".... not implemented yet!");
}

@Override
public int getLoginTimeout() throws SQLException {
throw new RuntimeException(".... not implemented yet!");
}

@Override
public Logger getParentLogger() throws SQLFeatureNotSupportedException {
throw new RuntimeException(".... not implemented yet!");
}

@Override
public <T> T unwrap(final Class<T> iface) throws SQLException {
throw new RuntimeException(".... not implemented yet!");
}

@Override
public boolean isWrapperFor(final Class<?> iface) throws SQLException {
throw new RuntimeException(".... not implemented yet!");
}

@Override
public boolean shouldClose(Connection con) {
  System.out.println("ibs_simple_datasource | not should close conection.");
  return false;
}

}
