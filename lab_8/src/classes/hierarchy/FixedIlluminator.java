package classes.hierarchy;

import java.io.Serializable;

public class FixedIlluminator extends Illuminator implements Serializable {
    private int lampsAmount;

    public FixedIlluminator(int lampsAmount, double luminousFlux,
                            String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        super(yearOfIssue, manufacturer, name, power, radiation);
        this.lampsAmount = lampsAmount;
        this.setLuminousFlux(luminousFlux);
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }



    public int getLampsAmount() {
        return lampsAmount;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + '\n'+ super.toString() + '\n' + this.lampsAmount;
    }
}
