package controller;

import model.CClothes;
import model.CContainer;
import model.CDestroyedClothes;
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
    public boolean load(CClothes clothesToWash) {
        if(getCurrentLoadLevel()+clothesToWash.getWeight() > getMaxWeightCapacity())
            return false;
        else {
            setCurrentLoadLevel(getCurrentLoadLevel()+clothesToWash.getWeight());
            return true;
        }
    }

    @Override
    public CClothes unload() {
        setCurrentLoadLevel(0);
        return clothesToWash;
    }

    @Override
    public void wash(int setWashTemperature) {
        if (clothesToWash.getWashTemperature() >= setWashTemperature) {
            clothesToWash.setWashed(true);
        } else if (clothesToWash.getWashTemperature() < setWashTemperature)
            clothesToWash = new CDestroyedClothes(getCurrentLoadLevel(),clothesToWash.getWashTemperature());
    }

    @Override
    public String getClothesColour() {
        return clothesToWash.getColour();
    }

    public CClothes getClothesToWash() {
        return clothesToWash;
    }

    public void setClothesToWash(CClothes clothesToWash) {
        this.clothesToWash = clothesToWash;
    }
}
