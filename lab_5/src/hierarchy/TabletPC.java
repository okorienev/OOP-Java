package hierarchy;

public class TabletPC extends PortableComputer {
    private String touchScreenType;
    private boolean hasKeyboard;

    public TabletPC(String touchScreenType, boolean hasKeyboard, double displaySize, String displayType,
                    String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.touchScreenType = touchScreenType;
        this.hasKeyboard = hasKeyboard;
        this.setDisplaySize(displaySize);
        this.setDisplayType(displayType);
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public TabletPC() {
    }

    public String getTouchScreenType() {
        return touchScreenType;
    }

    public void setTouchScreenType(String touchScreenType) {
        this.touchScreenType = touchScreenType;
    }

    public boolean isHasKeyboard() {
        return hasKeyboard;
    }

    public void setHasKeyboard(boolean hasKeyboard) {
        this.hasKeyboard = hasKeyboard;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' +
                "touchScreenType='" + touchScreenType + '\'' +
                ", hasKeyboard=" + hasKeyboard;
    }
}
