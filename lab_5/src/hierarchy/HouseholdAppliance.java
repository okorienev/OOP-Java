package hierarchy;

public class HouseholdAppliance extends ElectricalAppliance {
    private String function;

    public HouseholdAppliance(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Override
    public String toString() {
        return "HouseholdAppliance\n" + super.toString() + this.function;
    }
}
