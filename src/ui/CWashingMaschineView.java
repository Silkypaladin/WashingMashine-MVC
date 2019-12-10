package ui;

import java.util.Scanner;

public class CWashingMaschineView {

    private Scanner input = new Scanner(System.in);

    public String getUsersLaundryColour() {
        System.out.println("Proszę podać kolor prania (BLACK, WHITE, COLOURED): ");
        String colour = input.nextLine();
        return colour;
    }

    public double getUsersLaundryWeight() {
        System.out.println("Proszę podać ilość prania: ");
        double weight = input.nextDouble();
        input.nextLine();
        return weight;
    }

    public int setWashingTemperature() {
        System.out.println("Proszę podać temperaturę prania (int): ");
    }
}
