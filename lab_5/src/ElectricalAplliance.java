/**
 * abstract class representing Electrical Appliance
 * @author Oleksandr Korienev
 */

public abstract class ElectricalAplliance {
    private int yearOfIssue;
    private String manufacturer;
    private double power;
    private double radiation;
    private boolean isPlugged;

    /**
     * @param year year of manufacturing
     * @throws IllegalArgumentException if year > 2018
     */
    public void setYearOfIssue(int year) throws IllegalArgumentException{
        if (year > 2018){
            throw new IllegalArgumentException();
        }else{
            this.yearOfIssue = year;
        }
    }

    public void turnOn(){
        this.isPlugged = true;
    }

    public void turnOff(){
        this.isPlugged = false;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public double getPower() {
        return power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getRadiation() {
        return radiation;
    }

    public boolean isPlugged() {
        return isPlugged;
    }

    public void setManufacturer(String manufacturerName){
        manufacturer = manufacturerName;
    }

    public void setPower(double power1){
        power = power1;
    }

    public void setRadiation(double radiation1){
        radiation = radiation1;
    }

    @Override
    public String toString(){
        return String.format("Manufacturer: %s\nYear: %d\nPower: %s\nRadiation: %s\n",
                manufacturer, yearOfIssue, power, radiation);
    }

}

