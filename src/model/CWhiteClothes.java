package model;

public class CWhiteClothes extends CClothes {

    public CWhiteClothes(double weight, int washTemperature) {
        super(weight);
        setWashTemperature(30);
        setColour("WHITE");
    }
}
