package model;

public class CColouredClothes extends CClothes {

    public CColouredClothes(double weight, int washTemperature) {
        super(weight);
        setWashTemperature(40);
        setColour("COLOURED");
    }
}
