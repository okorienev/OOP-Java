package classes.hierarchy;

import java.io.Serializable;

public class HouseholdAppliance extends ElectricalAppliance implements Serializable {
    private String function;

    public HouseholdAppliance(String function,
                              String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.function = function;
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public HouseholdAppliance() {
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String representAsText() {
        return null;
    }

    @Override
    public ElectricalAppliance readFromText(String s) {
        return null;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' + this.function;
    }
}
