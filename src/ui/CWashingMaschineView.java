package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CWashingMaschineView {

    private Scanner input = new Scanner(System.in);

    public double getUsersLaundryWeight() {
        System.out.println("Proszę podać ilość prania (double): ");
        double weight;
        try {
            weight = input.nextDouble();
            input.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Błędny typ danych! proszę podaj dane ponownie: ");
            input.nextLine();
            weight = input.nextDouble();
            input.nextLine();
        }
        return weight;
    }

    public int setWashingTemperature() {
        int temperature;
        showSuggestedWashTemperatures();
        System.out.println("Proszę podać temperaturę prania (int): ");
        try {
            temperature = input.nextInt();
            input.nextLine();
            if (temperature <= 0) {
                System.out.println("Błędna temperatura! Proszę wprowadzić liczbę większą od 0.");
                setWashingTemperature();
            }
        } catch (InputMismatchException e) {
            System.out.println("Błędny typ danych! proszę podaj dane ponownie: ");
            input.nextLine();
            temperature = input.nextInt();
            input.nextLine();
        }
        return temperature;
    }

    public int getLaundryColour() {
        System.out.println("Podaj kolor ubrań do wyprania:");
        showColours();
        System.out.print("Wybór: ");
        int colour;
        try {
            colour = input.nextInt();
            input.nextLine();
            if (colour != 1 && colour != 2 && colour != 3) {
                System.out.println("Opcja nieobsługiwana przez pralkę! Spróbuj ponownie.");
                getLaundryColour();
            }
        } catch (InputMismatchException e) {
            System.out.println("Błędny typ danych! proszę podaj dane ponownie: ");
            input.nextLine();
            colour = input.nextInt();
            input.nextLine();
        }
        return colour;
    }

    public int getMenuChoice() {
        System.out.println("Proszę wybrać opcję: ");
        int choice;
        try {
            choice = input.nextInt();
            input.nextLine();
        } catch (InputMismatchException e) {
            input.nextLine();
            System.out.println("Błędny typ danych! proszę podaj dane ponownie: ");
            choice = input.nextInt();
            input.nextLine();
        }
        return choice;
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

    public void printMenuOptions() {
        System.out.println("1 - Załaduj pranie");
        System.out.println("2 - Rozładuj pranie");
        System.out.println("3 - Ustaw temperaturę prania i rozpocznij proces");
        System.out.println("4 - Wyłącz pralkę");
    }

    public void close() {
        input.close();
    }
}
