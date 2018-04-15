package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.Laptop;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class LaptopCreator extends ElectricalApplianceCreator {
    public LaptopCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new Laptop(
                data.get("keyboardType"),
                Boolean.parseBoolean(data.get("ScreenIsTouch")),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")));
    }
}
