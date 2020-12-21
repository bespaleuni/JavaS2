package by.gsu.pms;

import java.sql.*;

public class Logic {

    private Logic() {
    }

    public static void createTables(Connection connection) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(Const.CREATE_ENGLISH_WORDS_TABLE);
            statement.execute(Const.CREATE_RUSSIAN_WORDS_TABLE);
            statement.execute(Const.CREATE_DICTIONARY_TABLE);
        }
    }

    public static void translate(String word, Connection connection, String query) throws SQLException {

        try (PreparedStatement ps = connection.prepareStatement(query)) {

            final int WORD_INDEX = 1;
            ps.setString(WORD_INDEX, word);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.isBeforeFirst()) {
                    final int WORD_MEANING_INDEX = 1;
                    System.out.println("Translation:");
                    while (rs.next()) {
                        System.out.println(rs.getString(WORD_MEANING_INDEX));
                    }
                } else {
                    System.out.println("The word is missing from the dictionary");
                }
            }
        }
    }
}
