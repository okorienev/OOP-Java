package classes.hierarchy.test;

import classes.Flat;
import classes.hierarchy.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectricalApplianceTest {
    private ElectricalAppliance[] testData;

    @BeforeEach
    void setUp() {
        testData = new ElectricalAppliance[6];
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
    }

    @Test
    void setYearOfIssue() {
        for (ElectricalAppliance data : testData) {
            assertThrows(UnrealYearException.class, ()->data.setYearOfIssue(2019));
        }
        int year = 2018;
        for (ElectricalAppliance data : testData) {
            data.setYearOfIssue(year);
            assertEquals(year, data.getYearOfIssue());
        }
    }

    @Test
    void turn() {
        for (ElectricalAppliance datum : testData) {
            assertFalse(datum.isPlugged());
            datum.turnOn();
            assertTrue(datum.isPlugged());
            datum.turnOff();
            assertFalse(datum.isPlugged());
        }
    }

}