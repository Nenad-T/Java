
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        while (true) {
            System.out.print("Input the name of the book, empty stops: ");
            String name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }
            System.out.print("Input the age recommendation: ");
            int age = Integer.valueOf(scanner.nextLine());
            
            Book book = new Book(name, age);
            books.add(book);
        }
        
        Comparator<Book> comparator = Comparator
              .comparing(Book::getAge)
              .thenComparing(Book::getName);
        
        Collections.sort(books, comparator);
        
        System.out.println("");
        System.out.println(books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");
        for (Book a : books){
            System.out.println(a.getName() + " (recommended for " + a.getAge() + " year-olds or older)");
        }
    }

}
