package model;

public abstract class CClothes {

    private String colour;
    private double weight;
    private int washTemperature;
    private boolean isWashed;

    public CClothes(double weight, int washTemperature) {
        this.weight = weight;
        this.washTemperature = washTemperature;
        isWashed = false;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getWashTemperature() {
        return washTemperature;
    }

    public void setWashTemperature(int washTemperature) {
        this.washTemperature = washTemperature;
    }

    public boolean isWashed() {
        return isWashed;
    }

    public void setWashed(boolean washed) {
        isWashed = washed;
    }
}
