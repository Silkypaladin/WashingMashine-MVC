package model;

public abstract class CContainer {

    private double currentLoadLevel;
    private static final double MAX_WEIGHT_CAPACITY = 15;

    public abstract boolean isEmpty();
    public abstract boolean load(CClothes clothesToWash);
    public abstract CClothes unload();
    public abstract void wash(int setWashTemperature);
    public abstract String getClothesColour();


    public void setCurrentLoadLevel(double currentLoadLevel) {
        this.currentLoadLevel = currentLoadLevel;
    }

    public double getCurrentLoadLevel() {
        return currentLoadLevel;
    }

    public static double getMaxWeightCapacity() {
        return MAX_WEIGHT_CAPACITY;
    }
}
