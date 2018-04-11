package hierarchy;

public class Tool extends ElectricalAppliance {
    private String toolType;
    private String toolNoise;

    public Tool(String toolType, String toolNoise,
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

    public String getToolNoise() {
        return toolNoise;
    }

    public void setToolNoise(String toolNoise) {
        this.toolNoise = toolNoise;
    }
}
