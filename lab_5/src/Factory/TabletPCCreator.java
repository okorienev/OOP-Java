package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.TabletPC;

public class TabletPCCreator extends ElectricalApplianceCreator {
    public TabletPCCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new TabletPC(
                data.get("touchScreenType"),
                Boolean.parseBoolean(data.get("hasKeyboard")),
                Double.parseDouble(data.get("displaySize")),
                data.get("displayType"),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")));
    }
}
