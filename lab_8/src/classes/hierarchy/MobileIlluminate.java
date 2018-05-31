package classes.hierarchy;


import java.io.Serializable;
import java.lang.reflect.Field;

public class MobileIlluminate extends Illuminator implements Serializable {
    private String binding;

    public MobileIlluminate(String binding, double luminousFlux,
                            String manufacturer, String name, double power, double radiation, int yearOfIssue) {
        this.binding = binding;
        this.setLuminousFlux(luminousFlux);
        this.setManufacturer(manufacturer);
        this.setName(name);
        this.setPower(power);
        this.setRadiation(radiation);
        this.setYearOfIssue(yearOfIssue);
    }

    public MobileIlluminate() {
    }

    public String getBinding() {
        return binding;
    }

    public void setBinding(String binding) {
        this.binding = binding;
    }

//    private String writeFields(Object object) throws IllegalAccessException {
//        StringBuilder result = new StringBuilder();
//        for (Field field: object.getClass().getDeclaredFields()){
//            field.setAccessible(true);
//            result.append("<").append(field.getName()).append(">").append(field.get(this).toString()).
//                    append("</").append(field.getName()).append(">").append('\n');
//        }
//        return result.toString();
//    }
//    @Override
//    public String representAsText() throws IllegalAccessException, InterruptedException {
//        StringBuilder result = new StringBuilder();
//        result.append("<").append(this.getClass().getSimpleName()).append(">").append('\n');
//        result.append(writeFields(this));
//        Object object = new Object();
//        Class currentClass = this.getClass();
//        System.out.println(this.getClass().getName());
//        System.out.println(this.getClass().getSuperclass().getName());
//        System.out.println(this.getClass().getSuperclass().getSuperclass().getName());
//        while (currentClass.getClass() != object.getClass()){
//            System.out.println(currentClass.toString());
//            Thread.sleep(3500);
//            currentClass = currentClass.getClass().getSuperclass();
//            result.append(writeFields(this));
//        }
//        do {
//
//            result.append(writeFields(this));
//        }
//        result.append("</").append(this.getClass().getSimpleName()).append(">");
//        return result.toString();
//    }

    @Override
    public String representAsText() throws IllegalAccessException, InterruptedException {
        return null;
    }

    @Override
    public ElectricalAppliance readFromText(String s) throws IllegalAccessException{
        int startIndex, endIndex;
        for (Field field: this.getClass().getDeclaredFields()){
            field.setAccessible(true);
            System.out.println(field.getName() + field.get(this));
        }
        return null;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + '\n' + super.toString() + '\n' +
                "binding='" + binding + '\'';
    }
}
