package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class LaptopCreator extends ElectricalApplianceCreator {
    public LaptopCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
