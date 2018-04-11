package hierarchy;

public class Tool extends ElectricalAppliance {
    private String toolType;
    private String toolNoise;

    public Tool(String toolType, String toolNoise) {
        this.toolType = toolType;
        this.toolNoise = toolNoise;
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
