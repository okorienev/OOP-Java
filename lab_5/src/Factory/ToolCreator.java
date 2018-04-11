package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class ToolCreator extends ElectricalApplianceCreator {
    public ToolCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
