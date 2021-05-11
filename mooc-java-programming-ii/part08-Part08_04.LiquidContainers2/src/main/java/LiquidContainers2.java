
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container firstContainer = new Container();
        Container secondContainer = new Container();

        while (true) {
            System.out.println("First: " + firstContainer);
            System.out.println("Second: " + secondContainer);
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            if (command.equals("add")) {
                firstContainer.add(amount);
            }
            if (command.equals("move")) {
                
                int amountToMove = amount;
                if (firstContainer.contains() - amount < 0) {
                    amountToMove = firstContainer.contains();
                }
                firstContainer.remove(amount);
                secondContainer.add(amountToMove);
            }
            if (command.equals("remove")) {
                secondContainer.remove(amount);
            }
        }
    }

}
