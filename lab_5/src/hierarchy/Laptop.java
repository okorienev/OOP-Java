package hierarchy;

public class Laptop extends PortableComputer {
    private String keyboardType;
    private boolean ScreenIsTouch;

    public Laptop(String keyboardType, boolean screenIsTouch,
                  String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.keyboardType = keyboardType;
        this.ScreenIsTouch = screenIsTouch;
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);

    }

    public Laptop() {
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public boolean isScreenIsTouch() {
        return ScreenIsTouch;
    }

    public void setScreenIsTouch(boolean screenIsTouch) {
        ScreenIsTouch = screenIsTouch;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' +
                "keyboardType='" + keyboardType + '\'' +
                ", ScreenIsTouch=" + ScreenIsTouch;
    }
}
