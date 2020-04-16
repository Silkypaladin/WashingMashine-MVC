package model;

public class ColouredClothes extends Clothes {

    public ColouredClothes(double weight) {
        super(weight);
        setWashTemperature(40);
        setColour("COLOURED");
    }
}
