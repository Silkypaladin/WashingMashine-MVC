package controller;


import java.util.concurrent.TimeUnit;

public class WashingMachine {

    private CMachineController controller;

    public WashingMachine() {
        this.controller = new CMachineController();
    }

    private void loadMachine() {
        boolean loaded = controller.load();
        if (loaded) {
            System.out.println("Pralka załadowana, pamiętaj o zamknięciu drzwiczek!");
        } else {
            System.out.println("Zbyt wiele ubrań! Oprogramowanie nie pozwala na wykonanie prania.");
        }
    }

    private void unloadMachine() {
        if (!controller.isEmpty())
            controller.unload().toString();
        else
            System.out.println("Pralka jest pusta! Proszę ją załadować.");
    }

    private boolean startMachine() {
        if (!controller.isEmpty()) {
            controller.wash();
            System.out.println("Pralka wykonuje pranie...");
            process("Nabieranie wody");
            process("Pranie");
            process("Płukanie");
            process("Wirowanie");
            return true;
        } else
            System.out.println("Pralka jest pusta! Proszę ją załadować.");
        return false;
    }

    private void process(String procName) {
        System.out.print("\n"+procName+". ");
        for (int i = 3; i >= 0; i--){
            System.out.print(i+"... ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void menu() {
        System.out.println("Witaj! Czy chcesz skorzystać z tej inteligentnej pralki marki Szajsung?");
        controller.printMenu();
        int choice;
        boolean done = false;
        while (!done) {
            choice = controller.startWashingProcess();
            switch (choice) {
                case 1:
                    loadMachine();
                    break;
                case 2:
                    unloadMachine();
                    break;
                case 3:
                    done = startMachine();
                    break;
                case 4:
                    done = true;
                    break;
            }
            if(!done) controller.printMenu();
        }
        System.out.println("\n"+controller.getClothesState());
        System.out.println("Dziękujemy za skorzystanie z naszego sprzętu!");
        controller.closeInput();
    }

    public static void main(String[] args) {
        WashingMachine m = new WashingMachine();
        m.menu();
    }
}
