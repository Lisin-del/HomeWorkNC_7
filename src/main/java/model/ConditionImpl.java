package model;

import java.util.ArrayList;
import java.util.List;

public class ConditionImpl implements Condition {
    private List<Species> conditionForCage = new ArrayList<>();

    ConditionImpl(Species species) {
        conditionForCage.add(species);
    }



    @Override
    public List<Species> isAvailableFor() {
        return conditionForCage;
    }
}
