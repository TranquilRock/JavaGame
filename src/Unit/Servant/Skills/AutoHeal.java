package Unit.Servant.Skills;

import Unit.*;

import java.util.*;

public final class AutoHeal extends Skill {
    public AutoHeal() {
        super(1, 1, 10, false, true);
    }

    @Override
    public void Act(Unit performer, Vector<Unit> victim) {
        performer.addHP(100);
    }
}