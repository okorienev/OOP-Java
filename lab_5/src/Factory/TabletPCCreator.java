package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class TabletPCCreator extends ElectricalApplianceCreator {
    public TabletPCCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
