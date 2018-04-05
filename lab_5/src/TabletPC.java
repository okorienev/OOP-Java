public class TabletPC extends PortableComputer {
    private String touchScreenType;
    private boolean hasKeyboard;

    public TabletPC(String touchScreenType, boolean hasKeyboard) {
        this.touchScreenType = touchScreenType;
        this.hasKeyboard = hasKeyboard;
    }
}
