package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

/**
 * abstract creator class for factory
 */
public abstract class ElectricalApplianceCreator {
    private ArrayDictionary<String> data;
    public ElectricalApplianceCreator(ArrayDictionary<String> data) {
        this.data = data;
    }

    public abstract ElectricalAppliance create();

    public ArrayDictionary getData() {
        return data;
    }
}
