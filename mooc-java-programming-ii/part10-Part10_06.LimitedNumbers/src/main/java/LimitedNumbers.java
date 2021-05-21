
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> inputs = new ArrayList<>(); // reading inputs

        while (true) {
            int row =Integer.parseInt(scanner.nextLine());  
            if (row < 0) {
                break;
            }

            inputs.add(row);
        }
        inputs.stream()
                .filter(input -> input > 1 && input <= 5)
                .forEach(input -> System.out.println(input));
    }
}
