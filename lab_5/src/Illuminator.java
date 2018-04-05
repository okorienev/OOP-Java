/**
 *
 */

public abstract class Illuminator extends ElectricalAplliance {
    private double luminousFlux;

    public double getLuminousFlux() {
        return luminousFlux;
    }

    public void setLuminousFlux(double luminousFlux) {
        this.luminousFlux = luminousFlux;
    }
}
