package hierarchy;

public class Tool extends ElectricalAppliance {
    private String toolType;
    private int toolNoise;

    public Tool(String toolType, int toolNoise,
                String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.toolType = toolType;
        this.toolNoise = toolNoise;
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public Tool() {
    }

    public String getToolType() {
        return toolType;
    }

    public void setToolType(String toolType) {
        this.toolType = toolType;
    }

    public int getToolNoise() {
        return toolNoise;
    }

    public void setToolNoise(int toolNoise) {
        this.toolNoise = toolNoise;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' +
                "toolType='" + toolType + '\'' +
                ", toolNoise='" + toolNoise + '\'';
    }
}
