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
        ArrayDictionary data = super.getData();
        return new TabletPC(
                (String)data.get("touchScreenType"),
                (boolean)data.get("hasKeyboard"),
                (double)data.get("displaySize"),
                (String)data.get("displayType"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue"));
    }
}
