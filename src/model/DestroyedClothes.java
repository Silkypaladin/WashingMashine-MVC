package model;

public class DestroyedClothes extends Clothes {

    public DestroyedClothes(double weight) {
        super(weight);
        setColour("DESTROYED");
    }

    public String toString() {
        String msg = "O nie, zniszczone ubrania! to pewnie przez zbyt wysoką temperaturę prania.";
        return msg;
    }
}
