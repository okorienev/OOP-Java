import Dictionary.ArrayDictionary;
import Factory.ElectricalApplianceCreator;
import Factory.FactoryMethod;
import hierarchy.ElectricalAppliance;

import static parsing.JSONParser.parseFile;

public class Main {

    public static void main(String[] args) {
        ArrayDictionary<Object> a = parseFile("data_json/meizu_m5_c.json");
        FactoryMethod factoryMethod = new FactoryMethod();
        ElectricalApplianceCreator creator = factoryMethod.creator(a);
        ElectricalAppliance electricalAppliance = creator.create();
    }
}
