package hierarchy;

/**
 *
 */

public abstract class Illuminator extends ElectricalAppliance {
    private double luminousFlux;

    public double getLuminousFlux() {
        return luminousFlux;
    }

    public void setLuminousFlux(double luminousFlux) {
        this.luminousFlux = luminousFlux;
    }
}
