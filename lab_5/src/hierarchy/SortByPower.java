package hierarchy;

import java.util.Comparator;

public class SortByPower implements Comparator<ElectricalAppliance>{
    @Override
    public int compare(ElectricalAppliance o1, ElectricalAppliance o2) {
        return Double.compare(o1.getPower(), o2.getPower());
    }
}
