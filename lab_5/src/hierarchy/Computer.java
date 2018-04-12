package hierarchy;

public abstract class Computer extends ElectricalAppliance {
    private String systemArchitecture;

    public String getSystemArchitecture() {
        return systemArchitecture;
    }

    public void setSystemArchitecture(String systemArchitecture) {
        this.systemArchitecture = systemArchitecture;
    }

    @Override
    public String toString() {
        return super.toString() + '\n' + systemArchitecture;
    }
}
