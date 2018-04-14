package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;
import hierarchy.MobileIlluninator;

public class MobileIlluminatorCreator extends ElectricalApplianceCreator {
    public MobileIlluminatorCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary data = super.getData();
        return new MobileIlluninator(
                (String)data.get("binding"),
                (double)data.get("luminousFlux"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue"));
    }
}
