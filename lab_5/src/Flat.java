import hierarchy.ElectricalAppliance;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Flat {
    private ElectricalAppliance[] electricalAppliances;

    public Flat(ElectricalAppliance[] electricalAppliances) {
        this.electricalAppliances = electricalAppliances;
    }

    public ElectricalAppliance[] getElectricalAppliances() {
        return electricalAppliances;
    }

    public void sortByPower(){
        Arrays.sort(electricalAppliances, Comparator.comparing(ElectricalAppliance::getPower));
    }

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

    public void turnOnRandom(){
        int numbers = electricalAppliances.length/3;
        Random random = new Random();
        int n;
        for (int i = 0; i < numbers; i++) {
            electricalAppliances[random.nextInt(electricalAppliances.length)].turnOn();
            }
        }
}

