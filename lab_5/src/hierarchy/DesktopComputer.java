package hierarchy;

public class DesktopComputer extends Computer {
    private String motherboard;
    private String CPU;
    private String GPU;
    private String RAM;
    private int HardDriveCapacity;

    public DesktopComputer(String motherboard, String CPU, String GPU, String RAM, int hardDriveCapacity,
                           String manufacturer, String name, double power, double radiation, int yearOfIssue,
                           String systemArchitecture) {
        this.motherboard = motherboard;
        this.CPU = CPU;
        this.GPU = GPU;
        this.RAM = RAM;
        this.HardDriveCapacity = hardDriveCapacity;
        this.setSystemArchitecture(systemArchitecture);
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public DesktopComputer() {
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

    public int getHardDriveCapacity() {
        return HardDriveCapacity;
    }

    public void setHardDriveCapacity(int hardDriveCapacity) {
        HardDriveCapacity = hardDriveCapacity;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n'+ super.toString() + '\n' +
                "motherboard='" + motherboard + '\'' +
                ", CPU='" + CPU + '\'' +
                ", GPU='" + GPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", HardDriveCapacity='" + HardDriveCapacity + '\'' +
                '}';
    }
}
