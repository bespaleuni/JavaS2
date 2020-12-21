package by.gsu.pms;

import java.sql.*;

public class Logic {

    private Logic() {
    }

    public static void createTable(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(Const.CREATE_POINTS_TABLE);
        }
    }

    public static String search(int[] point, Connection connection, String query) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            final int x = 1;
            final int y = 2;
            ps.setInt(x, point[0]);
            ps.setInt(y, point[1]);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.isBeforeFirst()) {
                    final int POINT_INDEX = 1;
                    rs.next();
                    return rs.getString(POINT_INDEX);
                } else {
                    return "Please input correct point!";
                }
            }
        }
    }
}
