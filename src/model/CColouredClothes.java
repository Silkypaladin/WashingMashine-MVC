package model;

public class CColouredClothes extends CClothes {

    public CColouredClothes(double weight) {
        super(weight);
        setWashTemperature(40);
        setColour("COLOURED");
    }
}
