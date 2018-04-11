package hierarchy;

public class TabletPC extends PortableComputer {
    private String touchScreenType;
    private boolean hasKeyboard;

    public TabletPC(String touchScreenType, boolean hasKeyboard) {
        this.touchScreenType = touchScreenType;
        this.hasKeyboard = hasKeyboard;
    }

    public String getTouchScreenType() {
        return touchScreenType;
    }

    public void setTouchScreenType(String touchScreenType) {
        this.touchScreenType = touchScreenType;
    }

    public boolean isHasKeyboard() {
        return hasKeyboard;
    }

    public void setHasKeyboard(boolean hasKeyboard) {
        this.hasKeyboard = hasKeyboard;
    }
}
