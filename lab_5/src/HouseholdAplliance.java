public class HouseholdAplliance extends ElectricalAplliance {
    private String function;

    public HouseholdAplliance(String function) {
        this.function = function;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }
}
