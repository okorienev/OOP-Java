package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.Laptop;

public class LaptopCreator extends ElectricalApplianceCreator {
    public LaptopCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary data = super.getData();
        return new Laptop(
                (String)data.get("keyboardType"),
                (boolean)data.get("ScreenIsTouch"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue"));
    }
}
