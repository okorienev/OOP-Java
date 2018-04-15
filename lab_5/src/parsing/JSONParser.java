package parsing;

import Dictionary.ArrayDictionary;

import java.io.*;

/**
 * class simple JSON parsing
 */
public abstract class JSONParser {

    /**
     * @param path to json file
     * @return ArrayDictionary with key(String) and value(String) from json
     * has big problems when parsing anything with commas, colons and quotes
     */
    public static ArrayDictionary parseFile(String path){
        ArrayDictionary<String> result = new ArrayDictionary<>();
        String tmpFileString;
        String[] tmpStringParts;
        FileReader fileReader;
        try {
            fileReader = new FileReader(path);
        }catch (FileNotFoundException e){
            e.printStackTrace();
            return result;
        }
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        try{
            while ((tmpFileString = bufferedReader.readLine())  != null) {
                tmpStringParts = tmpFileString.split(":");
                if(tmpStringParts.length == 2){ //[0] is key and [1] is data
                    tmpStringParts[0] = tmpStringParts[0].replaceAll(" ", "");
                    tmpStringParts[0] = tmpStringParts[0].replaceAll("\"", "");
                    tmpStringParts[1] = tmpStringParts[1].replaceAll(" ", "");
                    tmpStringParts[1] = tmpStringParts[1].replaceAll(",", "");
                    tmpStringParts[1] = tmpStringParts[1].replaceAll("\"","");
                    result.append(tmpStringParts[1], tmpStringParts[0]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * parsing each file from directory with parseFile()
     * @param path to directory with json files
     * @return array of ArrayDictionary instances
     * @see JSONParser#parseFile(String)
     */
    public static ArrayDictionary[] parseDirectory(String path){
        File file = new File(path);
        File[] files = file.listFiles();
        ArrayDictionary[] result = new ArrayDictionary[files.length];
        for (int i = 0; i < files.length; i++) {
            result[i] = parseFile(files[i].getAbsolutePath());
        }
        return result;
    }
}
