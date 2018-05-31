package classes.hierarchy;


import java.io.Serializable;

public class Tool extends ElectricalAppliance implements Serializable {
    private String toolType;
    private int toolNoise;

    public Tool(String toolType, int toolNoise,
                String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        super(yearOfIssue,manufacturer, name, power, radiation);
        this.toolType = toolType;
        this.toolNoise = toolNoise;
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
