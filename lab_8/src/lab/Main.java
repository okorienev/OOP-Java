package lab;

import classes.hierarchy.*;
import list.MyList;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static ElectricalAppliance[] createDefaultElements() {
        ElectricalAppliance[] result = new ElectricalAppliance[4];
        result[0] = new ElectricalAppliance(
                2017,
                "Company inc.",
                "Appliance name",
                123.0,
                180.0
        );
        result[1] = new ElectricalAppliance(
                1901,
                "manufacturer",
                "DELUX",
                123,
                35
        );
        result[2] = new ElectricalAppliance(
                33,
                "Uknown",
                "Deadly artifact",
                Double.MAX_VALUE,
                Double.MAX_VALUE

        );
        result[3] = new ElectricalAppliance(
                33,
                "Uknown",
                "Lifefull artifact",
                Double.MAX_VALUE,
                Double.MAX_VALUE
        );
        return result;
    }

    public void Serialize(MyList list) throws Exception{
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
    }

    public void SerializeAndDeserializeText() throws Exception{
        //writing text
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter( new File("sequence.txt")));
        String delimiter = "---------";
        for (ElectricalAppliance appliance : createDefaultElements()) {
            bufferedWriter.write(MyTextSerializer.writeAsSimpleXml(appliance));
            bufferedWriter.write(delimiter);
        }
        bufferedWriter.close();
        //reading text
        BufferedReader bufferedReader = new BufferedReader(new FileReader("sequence.txt"));
        StringBuilder tmp = new StringBuilder();
        ArrayList<ElectricalAppliance> list = new ArrayList<>();
        String line;
        while ( (line = bufferedReader.readLine()) != null){
            tmp.append(line).append('\n');
        }
        ArrayList<String> listOfXMLs = new ArrayList<>(Arrays.asList(tmp.toString().split(delimiter)));
        ArrayList<ElectricalAppliance> objectsList = new ArrayList<>();
        for (String xml : listOfXMLs) {
            try{
                objectsList.add(MyTextSerializer.readElectricalApplianceFromXML(xml));
            }catch (Exception ignored){

            }
        }
        for (ElectricalAppliance appliance : objectsList) {
            System.out.println(appliance);
        }

    }

    public static void main(String[] args) throws Exception{


    }
}
