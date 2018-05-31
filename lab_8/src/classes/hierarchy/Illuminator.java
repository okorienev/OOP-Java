package classes.hierarchy;

import java.io.Serializable;


public class Illuminator extends ElectricalAppliance implements Serializable {
    private double luminousFlux;

    public Illuminator(int yearOfIssue, String manufacturer, String name, double power, double radiation) {
        super(yearOfIssue, manufacturer, name, power, radiation);
    }

    public double getLuminousFlux() {
        return luminousFlux;
    }

    public void setLuminousFlux(double luminousFlux) {
        this.luminousFlux = luminousFlux;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + this.luminousFlux;
    }
}
