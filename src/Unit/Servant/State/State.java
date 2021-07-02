package Unit.Servant.State;

import Unit.Servant.*;
import Unit.Unit;
import java.awt.*;
import java.awt.image.*;

//Specify minimum Servant's State
public abstract class State {
    public Servant s;
    private int attackCount = 0;
    private int walkCount = 0;
    private int deadCount = 0;
    protected int nAttackImage = 0;
    protected int nWalkImage = 0;
    protected int nDeadImage = 0;

    protected abstract BufferedImage attackImage(int index);

    protected abstract BufferedImage deadImage(int index);

    protected abstract BufferedImage walkImage(int index);

    protected Rectangle range = null;

    private void render(BufferedImage image, Graphics g) {
        if (!s.Camp) {
            g.drawImage(image, this.s.coordinate.x + range.width, Unit.MAX_HEIGHT - this.s.coordinate.y - range.height,
                    -range.width, range.height, null);
        } else {
            g.drawImage(image, this.s.coordinate.x, Unit.MAX_HEIGHT - this.s.coordinate.y - range.height, range.width,
                    range.height, null);
        }
    }

    protected void DrawWalk(Graphics g) {
        s.move(s.Camp);
        this.render(walkImage(walkCount), g);
        walkCount = reset(walkCount) + 1;
        walkCount %= nWalkImage;
    }

    protected void DrawAttack(Graphics g) {
        this.render(attackImage(attackCount), g);
        attackCount = reset(attackCount) + 1;
        attackCount %= nAttackImage;
    }

    protected void DrawDead(Graphics g) {
        this.render(deadImage(deadCount), g);
        deadCount = reset(deadCount) + 1;
        if (deadCount == nDeadImage) {
            s.onDead();
        }
    }

    protected int reset(int preserve) {
        attackCount = 0;
        walkCount = 0;
        return preserve;
    }

    public void update(Graphics g) {
        if (s.dead()) {
            this.DrawDead(g);
        } else if ((attackCount != 0) || ((attackCount == 0) && s.Attack())) {// Only Try when attackCount == 0;
            this.DrawAttack(g);
        } else {
            this.DrawWalk(g);
        }
    }
}
