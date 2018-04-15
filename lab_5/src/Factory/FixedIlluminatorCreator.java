package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.FixedIlluminator;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class FixedIlluminatorCreator extends ElectricalApplianceCreator {
    public FixedIlluminatorCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new FixedIlluminator(
                Integer.parseInt(data.get("lampsAmount")),
                Double.parseDouble(data.get("luminousFlux")),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")));
    }
}
