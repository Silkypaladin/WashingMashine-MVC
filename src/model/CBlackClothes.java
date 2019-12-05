package model;

public class CBlackClothes extends CClothes {

    public CBlackClothes(double weight, int washTemperature) {
        super(weight, washTemperature);
        setColour(CColourValues.BLACK);
    }
}
