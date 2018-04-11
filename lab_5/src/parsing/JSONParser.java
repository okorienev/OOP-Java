package parsing;

import Dictionary.ArrayDictionary;

import java.io.*;

public abstract class JSONParser {

    public static ArrayDictionary parseFile(String path){
        ArrayDictionary result = new ArrayDictionary();
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
}
