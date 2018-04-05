public class DesktopComputer extends Computer {
    private String motherboard;
    private String CPU;
    private String GPU;
    private String RAM;
    private String HardDriveCapacity;

    public DesktopComputer(String motherboard, String CPU, String GPU, String RAM, String hardDriveCapacity) {
        this.motherboard = motherboard;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.HardDriveCapacity = hardDriveCapacity;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHardDriveCapacity() {
        return HardDriveCapacity;
    }

    public void setHardDriveCapacity(String hardDriveCapacity) {
        HardDriveCapacity = hardDriveCapacity;
    }
}
