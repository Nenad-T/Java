package FlightControl;

import FlightControl.logic.FlightControl;
import FlightControl.ui.UI;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        FlightControl flightControl = new FlightControl();
        Scanner sc = new Scanner(System.in);
        UI ui = new UI(flightControl, sc);
        ui.start();
    }
}
