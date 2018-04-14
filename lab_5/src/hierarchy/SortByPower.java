package hierarchy;

import java.util.Comparator;

/**
 * changed to Comparator.comparing in sorting method
 */
@Deprecated
public class SortByPower implements Comparator<hierarchy.ElectricalAppliance>{
    @Override
    public int compare(hierarchy.ElectricalAppliance o1, hierarchy.ElectricalAppliance o2) {
        return Double.compare(o1.getPower(), o2.getPower());
    }
}
