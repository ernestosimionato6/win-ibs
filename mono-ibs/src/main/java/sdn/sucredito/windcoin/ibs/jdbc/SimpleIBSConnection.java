package sdn.sucredito.windcoin.ibs.jdbc;

import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;

import java.sql.Connection;

public class SimpleIBSConnection implements IBSConnection {
    @Override
    public void checkLoginUsr() throws Exception {

    }

    @Override
    public Boolean isValid(int timeout) throws Exception {
        return null;
    }

    @Override
    public void close() throws Exception {

    }

    @Override
    public Connection getSQLConnection() {
        return null;
    }

    @Override
    public SSGUsrCredentials getUsrCredentials() {
        return null;
    }
}
