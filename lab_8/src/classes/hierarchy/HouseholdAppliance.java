package classes.hierarchy;

import java.io.Serializable;

public class HouseholdAppliance extends ElectricalAppliance implements Serializable {
    private String function;

    public HouseholdAppliance(String function,
                              String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        super(yearOfIssue, manufacturer, name, power, radiation);
        this.function = function;
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }


    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }


    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' + this.function;
    }
}
