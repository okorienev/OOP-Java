import hierarchy.*;

/*
Визначити ієрархію електроприладів. Увімкнути деякі електроприлади в
розетку. Підрахувати споживану потужність. Провести сортування приладів у
квартирі на основі потужності. Знайти прилад у квартирі, що відповідає
заданому діапазону електор-магнітного випромінювання.
 */
public class Main {
    /**
     * creating default objects for given task
     * @return array appliances
     */
    public static ElectricalAppliance[] createDefaultElements(){
        ElectricalAppliance[] result = new ElectricalAppliance[6];
        result[0] = new CommunicationProvider(
                "RG-45",
                1,
                4,
                true,
                "TP-LINK",
                "TL-WR841N",
                13,
                100,
                2017

        );
        result[1] = new CommunicationProvider(
                "RG-45",
                1,
                1,
                false,
                "Panasonic",
                "KX-TS2365UAW",
                20,
                50,
                2015
        );
        result[2] = new FixedIlluminator(
                3,
                280,
                "NNB LIGHTNING",
                "Mila 59103",
                180,
                10,
                2018
        );
        result[3] = new MobileIlluninator(
                "On table",
                60,
                "DELUX",
                "TF-230",
                35,
                8,
                2014
        );
        result[4] = new Tool(
                "drill",
                90,
                "Bosch Professional",
                "GBM 6 RE",
                350,
                13,
                2018

        );
        result[5] = new HouseholdAppliance(
                "wine cooling",
                "LIEBHERR",
                "Wkt 4552",
                188,
                35,
                2018
        );
        return result;
    }
    public static void main(String[] args) {
        Flat flat = new Flat(createDefaultElements());
        System.out.println("objects in default order");
        for (ElectricalAppliance appliance : flat.getElectricalAppliances()) {
            System.out.println(appliance.shortenedRepresentation());
        }
        System.out.println();
        flat.sortByPower();
        System.out.println("objects sorted by power");
        for (ElectricalAppliance appliance : flat.getElectricalAppliances()) {
            System.out.println(appliance.shortenedRepresentation());
        }
        System.out.println();

        flat.turnOnItems(new int[]{1,3,5, 12});
        System.out.println("some items were turned on");
        for (ElectricalAppliance appliance : flat.getElectricalAppliances()) {
            System.out.println(appliance.shortenedRepresentation());
        }
        System.out.println();
        System.out.println("Total consumed power: " + flat.getTotalConsumedPower());
    }


}
