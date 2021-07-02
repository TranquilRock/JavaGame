package Unit.Servant.MaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import Unit.Servant.Skills.AutoHeal;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class MaleZombie extends Servant {
    static int initHP = 2000;
    static int initATK = 100;
    static int initDEF = 0;
    static BufferedImage Overview;
    static {
        try {
            Overview = ImageIO.read(new File("Assets/Servant/" + ServantName() + "/overview.png"));
        } catch (Exception e) {

        }
    }

    public MaleZombie(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new MaleZombieState(), world);
        this.stateControl.s = this;
        this.stride = 5;
        this.setNormalAttack(1, 80, 0, true, false);
        this.addSkill(new AutoHeal());
    }

    @Override
    public BufferedImage toImage() {
        return Overview;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return new MaleZombie(new Point(coordinate), Camp, world);
    }

    static public String ServantName() {
        return "MaleZombie";
    }
    
    static int cost = 80;
    @Override
    public int getCost() {
        return cost;
    }
}
