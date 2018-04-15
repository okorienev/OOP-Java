package Factory;

import Dictionary.ArrayDictionary;

/**
 * Factory method for hierarchy package
 */
public class FactoryMethod {
    /**
     * checking for parameters needed for ElectricalAppliance
     * @param parsedData dictionary with data about appliances
     * @return true if all parameters are present in dictionary and false otherwise
     */
    private boolean ElectricalApplianceParametersCorrect(ArrayDictionary parsedData){
        return parsedData.get("manufacturer") != null &
                parsedData.get("name") != null &
                parsedData.get("power") != null &
                parsedData.get("radiation") != null &
                parsedData.get("yearOfIssue") !=null;
    }

    /**
     * Each hierarchy class has unique parameters, method is searching in the inheritance graph tree, trying to get one of
     * class parameter (custom Dictionary returns null if parameter is not present in it)
     * @param parsedData dictionary with data about appliance
     * @return concrete creator depending on search results
     * @throws IllegalArgumentException if given dictionary suits no appliance from hierarchy
     */
    public ElectricalApplianceCreator creator(ArrayDictionary parsedData) throws IllegalArgumentException{
        ElectricalApplianceCreator electricalApplianceCreator;
        if (ElectricalApplianceParametersCorrect(parsedData)){
            if(parsedData.get("luminousFlux") != null){
                if(parsedData.get("binding") != null){
                    electricalApplianceCreator = new FixedIlluminatorCreator(parsedData);
                }else {
                    electricalApplianceCreator = new MobileIlluminatorCreator(parsedData);
                }
            }else if(parsedData.get("function") != null){
                electricalApplianceCreator = new HouseholdApplianceCreator(parsedData);
            }else if(parsedData.get("systemArchitecture") != null){
                if (parsedData.get("displayType") != null){
                    if (parsedData.get("hasKeyboard")!= null){
                        electricalApplianceCreator = new TabletPCCreator(parsedData);
                    }else {
                        electricalApplianceCreator = new LaptopCreator(parsedData);
                    }
                }else {
                    electricalApplianceCreator = new DesktopComputerCreator(parsedData);
                }
            }else if(parsedData.get("toolType") != null){
                electricalApplianceCreator = new ToolCreator(parsedData);
            }else {
                electricalApplianceCreator = new CommunicationProviderCreator(parsedData);
            }
            return electricalApplianceCreator;
        }else{
            throw new IllegalArgumentException();
        }
    }
}
