package controller;

import model.*;
import ui.CWashingMaschineView;

public class CMachineController extends CContainer {

    private CClothes clothesToWash;
    private CWashingMaschineView currentWash;

    public CMachineController(CClothes clothesToWash, CWashingMaschineView currentWash) {
        this.clothesToWash = clothesToWash;
        this.currentWash = currentWash;
        setCurrentLoadLevel(0);
    }

    @Override
    public boolean isEmpty() {
        return getCurrentLoadLevel() == 0;
    }


    @Override
    public boolean load() {
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

    @Override
    public CClothes unload() {
        setCurrentLoadLevel(0);
        return clothesToWash;
    }

    @Override
    public void wash(int WashTemperature) {
        if (clothesToWash.getWashTemperature() >= WashTemperature) {
            clothesToWash.setWashed(true);
        } else if (clothesToWash.getWashTemperature() < WashTemperature)
            clothesToWash = new CDestroyedClothes(getCurrentLoadLevel());
    }

    @Override
    public String getClothesColour() {
        return clothesToWash.getColour();
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

    public void startWashingProcess() {
        int washTemperature = currentWash.setWashingTemperature();
    }
}
