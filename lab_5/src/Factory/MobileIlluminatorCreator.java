package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.MobileIlluninator;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class MobileIlluminatorCreator extends ElectricalApplianceCreator {
    public MobileIlluminatorCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new MobileIlluninator(
                data.get("binding"),
                Double.parseDouble(data.get("luminousFlux")),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue")));
    }
}
