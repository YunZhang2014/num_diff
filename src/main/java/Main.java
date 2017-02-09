import java.util.Scanner;

/**
 * Created by Yun Zhang on 9/2/17.
 */
public class Main {
    public static void main(String[] args) {
        //first part load test data from a file and perform tests
        doTestFromTestDateFile();

        //second part: get test data from the standard input stream
        Scanner scanner = new Scanner(System.in);
        String input = "";
        DatePairParer datePairParer = new DatePairParerImpl();
        do {
            System.out.println("Please input \"exit\" if you want to exit the program");
            System.out.println("Please input a string whose format is DD MM YYYY, DD MM YYYY:");
            input = scanner.nextLine();
            try {
                DatePair datePair = datePairParer.parseDatePair(input);
                System.out.println(datePair);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }while(!input.trim().equalsIgnoreCase("exit"));
    }

    private static void doTestFromTestDateFile() {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("testData.txt"));
        String input = "";
        DatePairParer datePairParer = new DatePairParerImpl();
        System.out.println("test using data from testData.txt");
        while (scanner.hasNextLine()) {
            input = scanner.nextLine();
            try {
                DatePair datePair = datePairParer.parseDatePair(input);
                System.out.println(datePair);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
