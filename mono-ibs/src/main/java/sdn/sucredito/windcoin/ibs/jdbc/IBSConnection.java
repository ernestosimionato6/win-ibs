package sdn.sucredito.windcoin.ibs.jdbc;

import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;

import java.sql.Connection;

public interface IBSConnection {

    public Boolean isValid(int timeout) throws Exception;

    public void close() throws Exception;

    public Connection getSQLConnection();

}


