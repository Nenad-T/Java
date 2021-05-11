
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        while (!str.equals("end")) {
            int a = Integer.parseInt(str);
            int b = a * a * a;
            System.out.println(b);
            str = scanner.nextLine();
        }
        System.out.println("end");
    }
}
