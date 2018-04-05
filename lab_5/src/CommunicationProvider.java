/**
 * @author Oleksandr Korienev
 * @see ElectricalAplliance
 * class for routers, phones and other devices connected to different networks
 * pay to attention to lineTypes array to see the meaning of lineType number
 *
 */

public class CommunicationProvider extends ElectricalAplliance {
    private String lineType;
    private int inputsNumber;
    private int outputsNumber;
    private boolean isWireless;

    public CommunicationProvider(String lineType, int inputsNumber, int outputsNumber, boolean isWireless) {
        this.lineType = lineType;
        this.inputsNumber = inputsNumber;
        this.outputsNumber = outputsNumber;
        this.isWireless = isWireless;
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
}
