package ui;

import java.util.Scanner;

public class CWashingMaschineView {

    private Scanner input = new Scanner(System.in);

    public double getUsersLaundryWeight() {
        System.out.println("Proszę podać ilość prania: ");
        double weight = input.nextDouble();
        input.nextLine();
        return weight;
    }

    public int setWashingTemperature() {
        System.out.println("Proszę podać temperaturę prania (int): ");
        showSuggestedWashTemperatures();
        int temperature = input.nextInt();
        input.nextLine();
        return temperature;
    }

    public int getLaundryColour() {
        System.out.println("Podaj kolor ubrań do wyprania:");
        showColours();
        System.out.print("Wybór: ");
        int colour = input.nextInt();
        input.nextLine();
        if (colour != 1 && colour != 2 && colour != 3) {
            System.out.println("Opcja nieobsługiwana przez pralkę! Spróbuj ponownie.");
            getLaundryColour();
        }
        return colour;
    }

    private void showSuggestedWashTemperatures() {
        System.out.println("Sugerowane temperatury prania: ");
        System.out.println("Ubrania czarne - 35 stopni Celsjusza");
        System.out.println("Ubrania kolorowe - 40 stopni Celsjusza");
        System.out.println("Ubrania białe - 30 stopni Celsjusza");
    }

    private void showColours() {
        System.out.println("1 - BLACK");
        System.out.println("2 - WHITE");
        System.out.println("3 - COLOURED");
    }

    public static void main(String[] args) {
        CWashingMaschineView v = new CWashingMaschineView();
        v.getLaundryColour();
       // v.getUsersLaundryWeight();
    }
}
