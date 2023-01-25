package sdn.piano.ibs.commons.jdbc;

import org.springframework.jdbc.core.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.InvalidResultSetAccessException;
import org.springframework.jdbc.SQLWarningException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.datasource.ConnectionProxy;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.jdbc.support.JdbcAccessor;
import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.LinkedCaseInsensitiveMap;
import org.springframework.util.StringUtils;

import sdn.piano.ibs.commons.jdbc.connectionpool.IBSDataSource;



public class IBSJDBCTemplate extends JdbcTemplate {


public IBSJDBCTemplate() {
	System.out.println(" ibs_jdbc_template construct #"+this );
}

public IBSJDBCTemplate(DataSource dataSource) {
	System.out.println(" ibs_jdbc_template construct #"+this );
	setDataSource(dataSource);
	afterPropertiesSet();
}

public IBSJDBCTemplate(DataSource dataSource, boolean lazyInit) {
	System.out.println(" ibs_jdbc_template construct #"+this );
	setDataSource(dataSource);
	setLazyInit(lazyInit);
	afterPropertiesSet();
}


@Override
@Nullable
public <T> T execute(ConnectionCallback<T> action) throws DataAccessException {
	System.out.println(" ibs_jdbc_template -> execute #1 | " + this);

	Assert.notNull(action, "Callback object must not be null");

	Connection con = DataSourceUtils.getConnection(obtainDataSource());
	try {
		Connection conToUse = createConnectionProxy(con);
		return action.doInConnection(conToUse);
	}
	catch (SQLException ex) {
		String sql = getSql(action);
		DataSourceUtils.releaseConnection(con, getDataSource());
		con = null;
		throw translateException("ConnectionCallback", sql, ex);
	}
	finally {
		DataSourceUtils.releaseConnection(con, getDataSource());
	}
}


@Override
@Nullable
public <T> T execute(CallableStatementCreator csc, CallableStatementCallback<T> action)
		throws DataAccessException {
	System.out.println("ibs_jdbc_template execute #2 |  " + this);
	Assert.notNull(csc, "CallableStatementCreator must not be null");
	Assert.notNull(action, "Callback object must not be null");
	if (logger.isDebugEnabled()) {
		String sql = getSql(csc);
		logger.debug("Calling stored procedure" + (sql != null ? " [" + sql  + "]" : ""));
	}

	Connection con = DataSourceUtils.getConnection(obtainDataSource());
	CallableStatement cs = null;
	try {
		cs = csc.createCallableStatement(con);
		applyStatementSettings(cs);
		T result = action.doInCallableStatement(cs);
		handleWarnings(cs);
		return result;
	}
	catch (SQLException ex) {
		if (csc instanceof ParameterDisposer) {
			((ParameterDisposer) csc).cleanupParameters();
		}
		String sql = getSql(csc);
		csc = null;
		JdbcUtils.closeStatement(cs);
		cs = null;
		DataSourceUtils.releaseConnection(con, getDataSource());
		con = null;
		throw translateException("CallableStatementCallback", sql, ex);
	}
	finally {
		if (csc instanceof ParameterDisposer) {
			((ParameterDisposer) csc).cleanupParameters();
		}
		JdbcUtils.closeStatement(cs);
		DataSourceUtils.releaseConnection(con, getDataSource());
		((IBSDataSource)getDataSource()).releaseConnection(con);
	}
}



@Nullable
private <T> T execute(StatementCallback<T> action, boolean closeResources) throws DataAccessException {
	System.out.println(" ibs_jdbc_template -> execute and close " + this + " closeResources ? " + closeResources);
	closeResources = true;
	System.out.println(" forced to released resources ");
	Assert.notNull(action, "Callback object must not be null");

	Connection con = DataSourceUtils.getConnection(obtainDataSource());
	Statement stmt = null;
	try {
		stmt = con.createStatement();
		applyStatementSettings(stmt);
		T result = action.doInStatement(stmt);
		handleWarnings(stmt);
		return result;
	}
	catch (SQLException ex) {
		String sql = getSql(action);
		JdbcUtils.closeStatement(stmt);
		stmt = null;
		DataSourceUtils.releaseConnection(con, getDataSource());
		con = null;
		throw translateException("StatementCallback", sql, ex);
	}
	finally {
		if (closeResources) {
			JdbcUtils.closeStatement(stmt);
			DataSourceUtils.releaseConnection(con, getDataSource());
		}
	}
}



@Override
@Nullable
public <T> T execute(StatementCallback<T> action) throws DataAccessException {
	return execute(action, true);
}



@Override
public void execute(final String sql) throws DataAccessException {
	if (logger.isDebugEnabled()) {
		logger.debug("Executing SQL statement [" + sql + "]");
	}


	class ExecuteStatementCallback implements StatementCallback<Object>, SqlProvider {
		@Override
		@Nullable
		public Object doInStatement(Statement stmt) throws SQLException {
			stmt.execute(sql);
			return null;
		}
		@Override
		public String getSql() {
			return sql;
		}
	}

	execute(new ExecuteStatementCallback(), true);
}




@Nullable
private static String getSql(Object sqlProvider) {
	if (sqlProvider instanceof SqlProvider) {
		return ((SqlProvider) sqlProvider).getSql();
	}
	else {
		return null;
	}
}



}
