
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Checker checker = new Checker();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        Boolean isDay = checker.isDayOfWeek(input);
        Boolean allVowels = checker.allVowels(input);
        Boolean isTimeForm = checker.timeOfDay(input);
        if (isDay | allVowels | isTimeForm) {
            System.out.println("The form is correct.");
        } else {
            System.out.println("The form is incorrect.");
        }
    }
}
