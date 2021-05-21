
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>(); // reading inputs

        while (true) {
            String row = scanner.nextLine();
            if (row.isEmpty()) {
                break;
            }

            inputs.add(row);
        }
        inputs.stream().forEach(input -> System.out.println(input));
    }
}
