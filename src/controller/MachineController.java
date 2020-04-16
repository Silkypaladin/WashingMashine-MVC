package controller;

import model.*;
import view.WashingMaschineView;

public class MachineController extends Container {

    private Clothes clothesToWash;
    private WashingMaschineView currentWash;

    public MachineController() {
        this.currentWash = new WashingMaschineView();
        setCurrentLoadLevel(0);
    }

    boolean isEmpty() {
        return getCurrentLoadLevel() == 0;
    }


    boolean load() {
        double weight = currentWash.getUsersLaundryWeight();
        if (getCurrentLoadLevel() + weight > getMaxWeightCapacity())
            return false;
        else {
            int chosenColour = currentWash.getLaundryColour();
            createClothes(chosenColour,weight);
            setCurrentLoadLevel(getCurrentLoadLevel() + weight);
            return true;
        }
    }

    Clothes unload() {
        if (isEmpty())
            return null;
        setCurrentLoadLevel(0);
        return clothesToWash;
    }

    void wash() {
        int washTemperature = currentWash.setWashingTemperature();
        if (clothesToWash.getWashTemperature() >= washTemperature) {
            clothesToWash.setWashed(true);
        } else if (clothesToWash.getWashTemperature() < washTemperature)
            clothesToWash = new DestroyedClothes(getCurrentLoadLevel());
    }


    String getClothesState() {
        if (clothesToWash != null)
            return clothesToWash.toString();
        else return "Brak ubrań!";
    }

    private void createClothes(int chosenColour, double weight) {
        switch (chosenColour) {
            case 1:
                clothesToWash = new BlackClothes(weight);
                break;
            case 2:
                clothesToWash = new WhiteClothes(weight);
                break;
            case 3:
                clothesToWash  = new ColouredClothes(weight);
                break;
        }
    }

    int startWashingProcess() {
        return currentWash.getMenuChoice();
    }

    void printMenu() {
        currentWash.printMenuOptions();
    }

    void closeInput() {
        currentWash.close();
    }
}
