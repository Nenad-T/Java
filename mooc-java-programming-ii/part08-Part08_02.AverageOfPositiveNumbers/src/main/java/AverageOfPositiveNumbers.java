
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userInput = Integer.parseInt(scanner.nextLine());
        int count = 0;
        double sum = 0;
        while (true) {
            if (userInput == 0) {
                break;
            } else if (userInput > 0) {
                count++;
                sum += userInput;
                userInput = Integer.parseInt(scanner.nextLine());
                
            } else {
                userInput = Integer.parseInt(scanner.nextLine());
            }
        }
        if (count == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            double average = sum / count;
            System.out.println(average);
        }

    }
}
