import Dictionary.ArrayDictionary;
import Factory.ElectricalApplianceCreator;
import Factory.FactoryMethod;
import hierarchy.ElectricalAppliance;

import java.util.Arrays;

import static parsing.JSONParser.parseDirectory;
import static parsing.JSONParser.parseFile;

public class Main {

    public static void main(String[] args) {
        ArrayDictionary<String>[] dataJsons = parseDirectory("data_json");
        FactoryMethod factoryMethod = new FactoryMethod();
        ElectricalAppliance[] appliances = new ElectricalAppliance[dataJsons.length];
        for (int i = 0; i < dataJsons.length; i++) {
            ElectricalApplianceCreator creator = factoryMethod.creator(dataJsons[i]);
            appliances[i] = creator.create();
        }
        Flat flat = new Flat(appliances);
        for (ElectricalAppliance appliance : appliances) {
            System.out.println(appliance.shortenedRepresentation());
        }
    }
}
