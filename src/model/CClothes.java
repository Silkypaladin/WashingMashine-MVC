package model;

public class CClothes {

    private String colour;
    private double weight;
    private int washTemperature;
    private boolean isWashed;

    public CClothes(double weight) {
        this.weight = weight;
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

    public String toString() {
        String msg = "Ubrania koloru: " + colour + " Czy czyste? " + isWashed;
        return msg;
    }
}
