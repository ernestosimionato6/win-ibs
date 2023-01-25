package sdn.sucredito.windcoin.ibs.jdbc;

import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;

import java.sql.Connection;

interface IBSConnection {

    public void checkLoginUsr() throws Exception;

    public Boolean isValid(int timeout) throws Exception;

    public void close() throws Exception;

    public Connection getSQLConnection();

    public SSGUsrCredentials getUsrCredentials();
}
