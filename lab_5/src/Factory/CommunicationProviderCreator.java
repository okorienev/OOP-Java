package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.ElectricalAppliance;

public class CommunicationProviderCreator extends ElectricalApplianceCreator {
    public CommunicationProviderCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        return null;
    }
}
