
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Sakine
 */
public class UserInterface {
    
    private TodoList list;
    private Scanner sc;
    
    public UserInterface(TodoList list, Scanner sc) {
        this.list = list;
        this.sc = sc;
    }
    
    public void start() {
        while (true) {
            System.out.print("Command: ");
            String input = sc.nextLine();
            if (input.equals("stop")) {
                break;
            }
            if (input.equals("add")) {
                System.out.print("To Add: ");
                String task = sc.nextLine();
                list.add(task);
            }
            if (input.equals("list")) {
                list.print();
            }
            if (input.equals("remove")) {
                System.out.print("Which one is removed? ");
                int toRemove = sc.nextInt();
                list.remove(toRemove);
            }
        }
        
    }
    
}
