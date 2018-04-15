package Factory;

import Dictionary.ArrayDictionary;
import hierarchy.CommunicationProvider;
import hierarchy.ElectricalAppliance;

/**
 * concrete creator
 * @see FactoryMethod
 */
public class CommunicationProviderCreator extends ElectricalApplianceCreator {
    public CommunicationProviderCreator(ArrayDictionary data) {
        super(data);
    }

    @Override
    public ElectricalAppliance create() {
        ArrayDictionary<String> data = super.getData();
        return new CommunicationProvider(
                data.get("lineType"),
                Integer.parseInt(data.get("inputsNumber")),
                Integer.parseInt(data.get("outputsNumber")),
                Boolean.parseBoolean(data.get("isWireless")),
                data.get("manufacturer"),
                data.get("name"),
                Double.parseDouble(data.get("power")),
                Double.parseDouble(data.get("radiation")),
                Integer.parseInt(data.get("yearOfIssue"))
        );
    }
}
