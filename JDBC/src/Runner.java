import by.gsu.pms.Connect;
import by.gsu.pms.Logic;
import by.gsu.pms.Const;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        final String ENGLISH_WORDS_REGEX = "^[a-zA-Z]+$";
        final String RUSSIAN_WORDS_REGEX = "^[а-яА-ЯёЁ]+$";

        Connect.init("jdbc_lab", "root", "");

        try (Scanner sc = new Scanner(System.in);
             Connection connection = Connect.getConnection()) {

            String searchingWord;

            while (true) {
                searchingWord = sc.next();

                if (searchingWord.equals("exit")) {
                    return;
                }

                if (searchingWord.matches(ENGLISH_WORDS_REGEX)) {
                    Logic.translate(searchingWord, connection, Const.SELECT_ENGLISH_WORLD_TRANSLATION);
                } else if (searchingWord.matches(RUSSIAN_WORDS_REGEX)) {
                    Logic.translate(searchingWord, connection, Const.SELECT_RUSSIAN_WORLD_TRANSLATION);
                } else {
                    System.out.println("The word is incorrect");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
