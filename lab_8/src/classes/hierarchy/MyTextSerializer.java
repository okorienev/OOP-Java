package classes.hierarchy;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTextSerializer {

    /**
     *
     * @param object object of any class
     * @return list of all object fields with inherited from superclasses, returns empty list for Object instance
     */
    public static ArrayList<Field> getObjectFieldsWithAllInherited(Object object){
        ArrayList<Field> list = new ArrayList<>();
        Object objToCompare = new Object();
        Class clazz = object.getClass();
        while (!clazz.getSimpleName().equals(objToCompare.getClass().getSimpleName())){
            list.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }

        return list;
    }

    /**
     * @param object object of any class
     * @return XML representation of object
     * @throws IllegalAccessException should not be thrown cause of Field.setAccessible use
     */
    @NotNull
    public static String writeAsSimpleXml(Object object) throws IllegalAccessException{
        ArrayList<Field> list = getObjectFieldsWithAllInherited(object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<").append(object.getClass().getSimpleName()).append(">").append('\n');
        for (Field field : list) {
            field.setAccessible(true);
            stringBuilder.append("<").append(field.getName()).append(">");
            stringBuilder.append(field.get(object));
            stringBuilder.append("</").append(field.getName()).append(">").append('\n');
            field.setAccessible(false);
        }
        stringBuilder.append("</").append(object.getClass().getSimpleName()).append(">");
        return stringBuilder.toString();
    }

    /**
     * real crutch
     * @param XMLFile xml
     * @return
     */
    public static ElectricalAppliance readElectricalApplianceFromXML(String XMLFile){
        ArrayList<String> lines = new ArrayList<>();
        lines.addAll(Arrays.asList(XMLFile.split("\n")));
        String className = lines.get(0); // raw string with classname
        className = className.replace("<", "").replace(">", "");
        lines.remove(0);
//        lines.remove(lines.size() - 1);
//        System.out.println(className);
//        if (!className.equals("ElectricalAppliance")){
//            throw new IllegalArgumentException();
//        }

        return new ElectricalAppliance(
                Integer.parseInt(lines.get(0).replaceAll("<[a-zA-Z0-0]+>", "").replaceAll("</[a-zA-Z0-9]+>", "")),
                lines.get(1).replaceAll("<[a-zA-Z0-0]+>", "").replaceAll("</[a-zA-Z0-9]+>", ""),
                lines.get(2).replaceAll("<[a-zA-Z0-0]+>", "").replaceAll("</[a-zA-Z0-9]+>", ""),
                Double.parseDouble(lines.get(3).replaceAll("<[a-zA-Z0-0]+>", "").replaceAll("</[a-zA-Z0-9]+>", "")),
                Double.parseDouble(lines.get(4).replaceAll("<[a-zA-Z0-0]+>", "").replaceAll("</[a-zA-Z0-9]+>", ""))
        );
    }
//    public static Object readObjectFromXMl(String XMLFile) throws ClassNotFoundException{
//        String patternFieldName = "(?<=<)(.*)(?=>[a-zA-Z0-9])";
//        String patternFieldValue = "(?<=%s>)(.*)(?=</%s)";
//        ArrayList<String> lines = new ArrayList<>();
//        lines.addAll(Arrays.asList(XMLFile.split("\n")));
//        String className = lines.get(0); // raw string with classname
//        className = className.replace("<", "").replace(">", "");
////        System.out.println(className);
//        lines.remove(0); // remove classname from list
//        lines.remove(lines.size() - 1);
//        Class clazz = Class.forName(className);
//        Object object = clazz.newInstance();
//        System.out.println(clazz.getSimpleName());
//        return null;
//    }
}
