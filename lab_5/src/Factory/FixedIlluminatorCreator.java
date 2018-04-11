package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class FixedIlluminatorCreator extends ElectricalApplianceCreator {
    public FixedIlluminatorCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
