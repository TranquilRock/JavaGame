package Unit.Servant;

import Unit.*;
import Unit.Servant.Skills.*;
import Unit.Servant.State.State;
import GameScene.Game;
import java.util.*;
import java.awt.*;

/* A servant entity should inherit with state to bind Image to Class*/
public abstract class Servant extends Unit {

    public int stride = 0;
    protected int atk = 0;
    protected Vector<Skill> SKI = new Vector<Skill>();
    protected State stateControl = null;
    protected NormalAttack normalAttack = new NormalAttack(1, 200, 0, true, false);
    public abstract int getCost();
    public Servant(Point coordinate, boolean Camp, int hp, int atk, int def, State stateControl, Game myWorld) {// Used
        super(coordinate, Camp, hp, def, myWorld);
        this.atk = atk;
        this.stateControl = stateControl;
    }

    public void onDead() {
        this.myWorld.removeServant(this);
    }

    public Servant(int hp, int atk, int def, State stateControl, Game myWorld) {// Used when add to player
        super(new Point(100, 100), true, hp, def, myWorld);
        this.atk = atk;
        this.stateControl = stateControl;
    }

    public void setNormalAttack(int nTarget, int range, int cd, boolean toenemy, boolean toally) {
        normalAttack = new NormalAttack(nTarget, range, cd, toenemy, toally);
    }

    public void addSkill(Skill s) {
        SKI.add(s);
        SKI.sort(new Comparator<Skill>() {
            @Override
            public int compare(Skill left, Skill right) {
                return -1 * (left.cd - right.cd);
            }
        });
    }

    public void move(boolean direction) {
        if (direction) {
            this.coordinate.x += this.stride;
        } else {
            this.coordinate.x -= this.stride;
        }
    }

    public void slice(Graphics g) {// Vector<Unit> target
        Vector<Unit> target = null;
        for (Skill s : SKI) {
            if (s.CD() && (target = myWorld.getTarget(this, s)) != null) {
                s.Act(this, target);
            }
        }
        stateControl.update(g);// Everything that require animation will be wrapped inside.
    }

    public boolean Attack() {
        Vector<Unit> target = null;
        if (normalAttack.CD() && (target = myWorld.getTarget(this, normalAttack)) != null) {
            normalAttack.Act(this, target);
            return true;
        }
        return false;
    }

    public int ATK() {
        return this.atk;
    }

    public int addATK(int atk) {
        this.atk += atk;
        return this.atk;
    }

    public int addStride(int stride) {
        return this.stride += stride;
    }
}
