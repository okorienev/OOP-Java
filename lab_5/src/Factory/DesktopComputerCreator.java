package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.DesktopComputer;
import hierarchy.ElectricalAppliance;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class DesktopComputerCreator  extends ElectricalApplianceCreator {
    public DesktopComputerCreator(ArrayDictionary<String> data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new DesktopComputer(
                data.get("motherboard"),
                data.get("CPU"),
                data.get("GPU"),
                data.get("RAM"),
                Integer.parseInt(data.get("hardDriveCapacity")),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")),
                data.get("systemArchitecture"));
    }
}
