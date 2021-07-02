package Unit.Servant.FemaleZombie;

import Unit.*;
import Unit.Servant.Servant;
import Unit.Servant.Skills.Strengthen;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class FemaleZombie extends Servant {
    static int initHP = 500;
    static int initATK = 50;
    static int initDEF = 50;
    static BufferedImage Overview;
    static {
        try {
            Overview = ImageIO.read(new File("Assets/Servant/" + ServantName() + "/overview.png"));
        } catch (Exception e) {

        }
    }
    public FemaleZombie(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new FemaleZombieState(), world);
        this.stateControl.s = this;
        this.stride = 13;
        this.setNormalAttack(1, 130, 0, true, false);
        this.addSkill(new Strengthen());
    }

    @Override
    public BufferedImage toImage() {
        return Overview;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return new FemaleZombie(new Point(coordinate), Camp, world);
    }
    
    static public String ServantName() {
        return "FemaleZombie";
    }
    
    static int cost = 50;

    @Override
    public int getCost() {
        return cost;
    }
}
