package model;

public class CDestroyedClothes extends CClothes {

    public CDestroyedClothes(double weight) {
        super(weight);
        setColour("DESTROYED");
    }

    public String toString() {
        String msg = "O nie, zniszczone ubrania! to pewnie przez zbyt wysoką temperaturę prania.";
        return msg;
    }
}
