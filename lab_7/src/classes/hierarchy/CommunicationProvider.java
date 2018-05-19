package classes.hierarchy;

/**
 * @author Oleksandr Korienev
 * @see ElectricalAppliance
 * class for routers, phones and other devices connected to different networks
 */

public class CommunicationProvider extends ElectricalAppliance {
    private String lineType;
    private int inputsNumber;
    private int outputsNumber;
    private boolean isWireless;

    public CommunicationProvider() {
    }

    public CommunicationProvider(String lineType, int inputsNumber, int outputsNumber, boolean isWireless,
                                 String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.lineType = lineType;
        this.inputsNumber = inputsNumber;
        this.outputsNumber = outputsNumber;
        this.isWireless = isWireless;
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public String getLineType() {
        return lineType;
    }

    public void setLineType(String lineType) {
        this.lineType = lineType;
    }

    public int getInputsNumber() {
        return inputsNumber;
    }

    public void setInputsNumber(int inputsNumber) {
        this.inputsNumber = inputsNumber;
    }

    public int getOutputsNumber() {
        return outputsNumber;
    }

    public void setOutputsNumber(int outputsNumber) {
        this.outputsNumber = outputsNumber;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean wireless) {
        isWireless = wireless;
    }

    @Override
    public String toString() {
        return  this.getClass().getName() + '\n' + super.toString() + '\n' +
                "lineType='" + lineType + '\'' +
                ", inputsNumber=" + inputsNumber +
                ", outputsNumber=" + outputsNumber +
                ", isWireless=" + isWireless;
    }
}
