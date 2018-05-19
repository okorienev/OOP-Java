package classes.hierarchy;

/**
 * abstract class representing Electrical Appliance
 * @author Oleksandr Korienev
 */

public abstract class ElectricalAppliance {
    private int yearOfIssue;
    private String manufacturer;
    private String name;
    private double power;
    private double radiation;
    private boolean isPlugged = false;

    /**
     * @param year year of manufacturing
     * @throws IllegalArgumentException if year > 2018
     */
    public void setYearOfIssue(int year) throws IllegalArgumentException{
        if (year > 2018){
            throw new UnrealYearException();
        }else{
            this.yearOfIssue = year;
        }
    }

    /**
     * method turning appliance on
     */
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("Manufacturer: %s\nYear: %d\nPower: %s\nRadiation: %s\n",
                manufacturer, yearOfIssue, power, radiation);
    }

    /**
     * @return shortened string representation of object
     */
    public String shortenedRepresentation(){
        return this.getClass().getName() +' ' + manufacturer +' '+ name +
                " radiation: " + radiation + " power: " +power + ' ' + "plugged: " + isPlugged;
    }
}

