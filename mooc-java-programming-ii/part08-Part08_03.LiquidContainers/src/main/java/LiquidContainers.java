
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;
        int max = 100;

        while (true) {
            System.out.println("First: " + firstContainer + "/ " + max);
            System.out.println("Second: " + secondContainer + "/" + max);
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);
            if (command.equals("add")) {
                if (firstContainer + amount >= max) {
                    firstContainer = max;
                } else if (amount > 0) {
                    firstContainer += amount;
                }

            } else if (command.equals("move")) {
                int amountToMove = amount;
                if (firstContainer - amount < 0) {
                    amountToMove = firstContainer;
                    firstContainer = 0;
                } else {
                    firstContainer -= amountToMove;
                }
                secondContainer += amountToMove;
                System.out.println(secondContainer);
                if (secondContainer > max) {
                    secondContainer = max;
                }
            } else if (command.equals("remove")) {
                if (secondContainer - amount < 0) {
                    secondContainer = 0;
                } else {
                    secondContainer -= amount;
                }

            }

        }
    }

}
