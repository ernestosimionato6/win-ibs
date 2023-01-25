package sdn.sucredito.windcoin.ibs.jdbc;

import sdn.sucredito.windcoin.ibs.ssg.jdbc.model.SSGUsrCredentials;

public interface IBSConnectionInTerminal {

    public void checkLoginUsr() throws Exception;

    public SSGUsrCredentials getUsrCredentials();
}
