package hierarchy;

public class Laptop extends PortableComputer {
    private String keyboardType;
    private boolean ScreenIsTouch;

    public Laptop(String keyboardType, boolean screenIsTouch) {
        this.keyboardType = keyboardType;
        this.ScreenIsTouch = screenIsTouch;
    }

    public String getKeyboardType() {
        return keyboardType;
    }

    public void setKeyboardType(String keyboardType) {
        this.keyboardType = keyboardType;
    }

    public boolean isScreenIsTouch() {
        return ScreenIsTouch;
    }

    public void setScreenIsTouch(boolean screenIsTouch) {
        ScreenIsTouch = screenIsTouch;
    }
}
