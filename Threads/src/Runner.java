import by.gsu.pms.OperationType;
import by.gsu.pms.ThreadGenerator;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите количество потоков: ");
        int countOfThreads = scan.nextInt();
        System.out.println("Введите число а, большее количества потоков в 2 и более раз: ");
        int maxValue = scan.nextInt();
        System.out.println("Выберите тип операции ('1 - сложение', '2 - вычитание', '3 - умножение");
        String operationType = scan.next();

        OperationType op = OperationType.ADDITION;

        switch (operationType) {
            case "1":
                op = OperationType.ADDITION;
                break;
            case "2":
                op = OperationType.SUBTRACTION;
                break;
            case "3":
                op = OperationType.MULTIPLICATION;
                break;
            default:
                System.out.println("Ошибка! Выберите один из предложенных вариантов");
        }

        ThreadGenerator calculator = new ThreadGenerator(countOfThreads, op, maxValue);
        calculator.execute();
        System.out.println("Результат (2а+1)!: " + calculator.getResult());
    }
}
