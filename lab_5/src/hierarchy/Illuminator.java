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

    @Override
    public String toString() {
        return super.toString() + '\n' + this.luminousFlux;
    }
}
