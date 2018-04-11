package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class HouseholdApplianceCreator extends ElectricalApplianceCreator {
    public HouseholdApplianceCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
