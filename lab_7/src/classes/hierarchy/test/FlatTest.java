package classes.hierarchy.test;

import classes.Flat;
import classes.hierarchy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FlatTest {
    Flat flat;

    @BeforeEach
    void setUp() {
        ElectricalAppliance[] testData = new ElectricalAppliance[6];
        testData[0] =new Tool(
                "drill",
                90,
                "Bosch Professional",
                "GBM 6 RE",
                350,
                13,
                2018);
        testData[1] = new CommunicationProvider(
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
        testData[2] = new CommunicationProvider(
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
        testData[3] = new FixedIlluminator(
                3,
                280,
                "NNB LIGHTNING",
                "Mila 59103",
                180,
                10,
                2018
        );
        testData[4] = new MobileIlluninator(
                "On table",
                60,
                "DELUX",
                "TF-230",
                35,
                8,
                2014
        );
        testData[5] = new HouseholdAppliance(
                "wine cooling",
                "LIEBHERR",
                "Wkt 4552",
                188,
                35,
                2018
        );
        flat = new Flat(testData);
    }

    @Test
    void sortByPower() {
        flat.sortByPower();
        ElectricalAppliance[] appliances = flat.getElectricalAppliances();
        for (int i = 0; i < appliances.length - 2; i++) {
            assertTrue(appliances[i].getPower() < appliances[i+1].getPower());
        }
    }

    @Test
    void getInRadiationRange() {
        assertEquals(0, flat.getInRadiationRange(0, 7).length);
        assertEquals(1, flat.getInRadiationRange(10, 10).length);
        assertEquals(flat.getElectricalAppliances().length,
                flat.getInRadiationRange(Integer.MIN_VALUE, Integer.MAX_VALUE).length);
    }

    @Test
    void turnOnItems() {
        int[] numbers = new int[]{0, 1, 2};
        flat.turnOnItems(numbers);
        for (int number : numbers) {
            assertTrue(flat.getElectricalAppliances()[number].isPlugged());
            assertFalse(flat.getElectricalAppliances()[number + numbers.length].isPlugged());
        }
    }

    @Test
    void getTotalConsumedPower() {
        assertEquals(0, flat.getTotalConsumedPower());
        int powersum = 0;
        flat.turnOnItems(new int[]{0,1});
        powersum += flat.getElectricalAppliances()[0].getPower();
        powersum += flat.getElectricalAppliances()[1].getPower();
        assertEquals(powersum, flat.getTotalConsumedPower());

    }

}