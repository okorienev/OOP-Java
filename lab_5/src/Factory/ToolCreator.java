package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.Tool;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class ToolCreator extends ElectricalApplianceCreator {
    public ToolCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new Tool(
                data.get("toolType"),
                Integer.parseInt(data.get("toolNoise")),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")));
    }
}
