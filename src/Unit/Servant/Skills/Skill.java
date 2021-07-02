package Unit.Servant.Skills;

import Unit.*;

import java.util.*;

public abstract class Skill {
    public int cd = 1;
    public int range = 1;
    public int nTarget = 1;
    public boolean toenemy = false;
    public boolean toally = false;
    private int CoolDownCounter = 0;

    public Skill(int nTarget, int range, int cd, boolean toenemy, boolean toally) {
        this.nTarget = nTarget;
        this.toenemy = toenemy;
        this.toally = toally;
        this.range = range;
        this.cd = cd;
    }

    public abstract void Act(Unit performer, Vector<Unit> victim);

    public boolean CD() {
        return (CoolDownCounter++) >= cd;
    }
    
    public boolean reachable(Unit performer, Unit victim) {
        return (Math.abs(performer.coordinate.x - victim.coordinate.x) <= this.range);
    }
}
