package classes.hierarchy;

public class MobileIlluninator extends Illuminator {
    private String binding;

    public MobileIlluninator(String binding, double luminousFlux,
                             String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.binding = binding;
        this.setLuminousFlux(luminousFlux);
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public MobileIlluninator() {
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' +
                "binding='" + binding + '\'';
    }
}
