package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.DesktopComputer;
import hierarchy.ElectricalAppliance;

public class DesktopComputerCreator  extends ElectricalApplianceCreator {
    public DesktopComputerCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary data = super.getData();
        return new DesktopComputer(
                (String)data.get("motherboard"),
                (String)data.get("CPU"),
                (String)data.get("GPU"),
                (String)data.get("RAM"),
                (int)data.get("hardDriveCapacity"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue"),
                (String)data.get("systemArchitecture"));
    }
}
