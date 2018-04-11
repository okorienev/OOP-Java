package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public abstract class ElectricalApplianceCreator {
    private ArrayDictionary data;
    public ElectricalApplianceCreator(ArrayDictionary data) {
        this.data = data;
    }

    public abstract ElectricalAppliance create();
}
