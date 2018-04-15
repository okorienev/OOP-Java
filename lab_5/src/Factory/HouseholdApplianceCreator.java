package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.HouseholdAppliance;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class HouseholdApplianceCreator extends ElectricalApplianceCreator {
    public HouseholdApplianceCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new HouseholdAppliance(
                data.get("function"),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")));
    }
}
