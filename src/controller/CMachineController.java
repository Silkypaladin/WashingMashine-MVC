package controller;

import model.*;
import ui.CWashingMaschineView;

public class CMachineController extends CContainer {

    private CClothes clothesToWash;
    private CWashingMaschineView currentWash;

    public CMachineController() {
        this.currentWash = new CWashingMaschineView();
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

    CClothes unload() {
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
            clothesToWash = new CDestroyedClothes(getCurrentLoadLevel());
    }


    String getClothesState() {
        if (clothesToWash != null)
            return clothesToWash.toString();
        else return "Brak ubrań!";
    }

    private void createClothes(int chosenColour, double weight) {
        switch (chosenColour) {
            case 1:
                clothesToWash = new CBlackClothes(weight);
                break;
            case 2:
                clothesToWash = new CWhiteClothes(weight);
                break;
            case 3:
                clothesToWash  = new CColouredClothes(weight);
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
