import Dictionary.ArrayDictionary;
import parsing.JSONParser;

import static parsing.JSONParser.*;

public class Main {

    public static void main(String[] args) {
        ArrayDictionary<Object> a = parseFile("data_json/meizu_m5_c.json");
        System.out.println(a);
        System.out.println(a.get("manufacturer"));
        System.out.println(a.get("yearOfIssue"));
        System.out.println(a.get("power"));
        System.out.println(a.get("non-existing"));
    }
}
