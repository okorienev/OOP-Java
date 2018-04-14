package hierarchy;

abstract class PortableComputer extends Computer {
    private String DisplayType;
    private double DisplaySize;

    public String getDisplayType() {
        return DisplayType;
    }

    public void setDisplayType(String displayType) {
        DisplayType = displayType;
    }

    public double getDisplaySize() {
        return DisplaySize;
    }

    public void setDisplaySize(double displaySize) {
        DisplaySize = displaySize;
    }

    @Override
    public String toString() {
        return  super.toString() + '\n' +
                "DisplayType='" + DisplayType + '\'' +
                ", DisplaySize=" + DisplaySize;
    }
}
