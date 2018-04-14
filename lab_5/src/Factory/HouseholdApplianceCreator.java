package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.HouseholdAppliance;

public class HouseholdApplianceCreator extends ElectricalApplianceCreator {
    public HouseholdApplianceCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary data = super.getData();
        return new HouseholdAppliance(
                (String)data.get("function"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue"));
    }
}
