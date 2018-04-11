package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class DesktopComputerCreator  extends ElectricalApplianceCreator {
    public DesktopComputerCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
