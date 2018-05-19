package classes;
import classes.hierarchy.*;

import java.util.Arrays;
import java.util.Comparator;

public class Flat {
    private ElectricalAppliance[] electricalAppliances;

    public Flat(ElectricalAppliance[] electricalAppliances) {
        this.electricalAppliances = electricalAppliances;
    }

    public ElectricalAppliance[] getElectricalAppliances() {
        return electricalAppliances;
    }

    /**
     * sorting array of appliances
     * @see Comparator
     */
    public void sortByPower(){
        Arrays.sort(electricalAppliances, Comparator.comparing(ElectricalAppliance::getPower));
    }

    /**
     * @param start of search range including first
     * @param end of search range including last
     * @return ElectricalAppliance array of items with .radiation within given range
     */
    public ElectricalAppliance[] getInRadiationRange(int start, int end){
        int count = 0;
        ElectricalAppliance[] result = new ElectricalAppliance[electricalAppliances.length];
        ElectricalAppliance[] resultCut;
        for (ElectricalAppliance appliance : electricalAppliances) {
            if(appliance.getRadiation() >= start & appliance.getRadiation() <= end){
                result[count++] = appliance;
            }
        }
        resultCut = new ElectricalAppliance[count];
        System.arraycopy(result, 0, resultCut, 0, resultCut.length);
        return resultCut;
    }

    /**
     * Turns on appliances in flat, writes warning if item index is out of bound for appliance array
     * @param numbers numbers of items to turn on array
     */
    public void turnOnItems(int[] numbers){
        for (int number : numbers) {
            if(number < electricalAppliances.length){
                electricalAppliances[number].turnOn();
            }else {
                System.err.println("Number "+ number + " is out of array range, it was skipped");
            }
        }
    }
    /**
     * @return sum of all .isPlugged appliances
     */
    public double getTotalConsumedPower(){
        double result = 0;
        for (ElectricalAppliance appliance : electricalAppliances) {
            if(appliance.isPlugged()){
                result += appliance.getPower();
            }
        }
        return result;
    }
}

