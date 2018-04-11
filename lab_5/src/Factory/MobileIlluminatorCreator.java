package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class MobileIlluminatorCreator extends ElectricalApplianceCreator {
    public MobileIlluminatorCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
