import by.gsu.pms.Connect;
import by.gsu.pms.Logic;
import by.gsu.pms.Const;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Connect.init("jdbc_lab", "root", "");

        try (Scanner sc = new Scanner(System.in);
             Connection connection = Connect.getConnection()) {
            //Logic.createTable(connection);
            int[] point = new int[2];
            System.out.println("Input x:");
            point[0] = sc.nextInt();
            System.out.println("Input y:");
            point[1] = sc.nextInt();
            System.out.println("Select searching method (1 - search for the nearest point, 2 - search for the farthest point):");
            int method = sc.nextInt();
                switch (method) {
                    case (1): {
                        System.out.println("The nearest point is in range: " + Logic.search(point, connection, Const.SELECT_NEAREST_POINT));
                        break;
                }
                    case (2): {
                        System.out.println("The farthest point is in range: " + Logic.search(point, connection, Const.SELECT_FARTHEST_POINT));
                        break;
                }
                    default: {
                        System.out.println("Incorrect method!");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
