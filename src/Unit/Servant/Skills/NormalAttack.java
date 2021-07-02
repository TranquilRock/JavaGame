package Unit.Servant.Skills;

import Unit.*;
import Unit.Servant.*;

import java.util.*;

public final class NormalAttack extends Skill {
   //"Every Servant possess this skill.";

    public NormalAttack(int nTarget, int range, int cd, boolean toenemy, boolean toally) {
        super(nTarget, range, cd, toenemy, toally);
    }

    @Override
    public void Act(Unit performer, Vector<Unit> victim) {
        for (Unit u : victim) {
            if (u != null) {
                u.takeDamage(((Servant) performer).ATK());
            }
        }
    }
}