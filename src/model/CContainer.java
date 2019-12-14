package model;

public abstract class CContainer {

    private double currentLoadLevel;
    private static final double MAX_WEIGHT_CAPACITY = 15;

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
