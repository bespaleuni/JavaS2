package by.gsu.pms;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Connect {
    private static Connect serviceDb = null;
    private static MysqlDataSource dataSource;

    private Connect(String dbName, String user, String password) {
        final String connectionHeader = "jdbc:mysql://localhost:3306/";
        final String connectionFooter = "?serverTimezone=Europe/Minsk";

        dataSource = new MysqlDataSource();
        dataSource.setUrl(connectionHeader + "dbName" + connectionFooter);
        dataSource.setUser("root");
        dataSource.setPassword("");
    }

    public static void init(String dbName, String user, String password) {
        if (serviceDb != null) {
            return;
        }
        serviceDb = new Connect(dbName, user, password);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
