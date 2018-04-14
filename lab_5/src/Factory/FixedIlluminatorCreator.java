package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.FixedIlluminator;

public class FixedIlluminatorCreator extends ElectricalApplianceCreator {
    public FixedIlluminatorCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary data = super.getData();
        return new FixedIlluminator(
                (int)data.get("lampsAmount"),
                (double)data.get("luminousFlux"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue"));
    }
}
