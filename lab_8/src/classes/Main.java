package classes;

import classes.hierarchy.*;

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
        ElectricalAppliance[] result = new ElectricalAppliance[4];
        result[0] = new FixedIlluminator(
                3,
                280,
                "NNB LIGHTNING",
                "Mila 59103",
                180,
                10,
                2018
        );
        result[1] = new MobileIlluminate(
                "On table",
                60,
                "DELUX",
                "TF-230",
                35,
                8,
                2014
        );
        result[2] = new Tool(
                "drill",
                90,
                "Bosch Professional",
                "GBM 6 RE",
                350,
                13,
                2018

        );
        result[3] = new HouseholdAppliance(
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
        ElectricalAppliance[] electricalAppliances = createDefaultElements();
        try {
            System.out.println(electricalAppliances[1].representAsText());
        }catch (IllegalAccessException | InterruptedException e){
            e.printStackTrace();
        }

    }


}
