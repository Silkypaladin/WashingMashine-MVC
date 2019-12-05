package model;

public class CWhiteClothes extends CClothes {

    public CWhiteClothes(double weight, int washTemperature) {
        super(weight, washTemperature);
        setColour(CColourValues.WHITE);
    }
}
