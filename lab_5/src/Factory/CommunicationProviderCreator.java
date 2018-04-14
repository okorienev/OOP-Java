package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.CommunicationProvider;
import hierarchy.ElectricalAppliance;

public class CommunicationProviderCreator extends ElectricalApplianceCreator {
    public CommunicationProviderCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary data = super.getData();
        return new CommunicationProvider(
                (String)data.get("lineType"),
                (int)data.get("inputsNumber"),
                (int)data.get("outputsNumber"),
                (boolean)data.get("isWireless"),
                (String)data.get("manufacturer"),
                (String)data.get("name"),
                (double)data.get("power"),
                (double)data.get("radiation"),
                (int)data.get("yearOfIssue")
        );
    }
}
