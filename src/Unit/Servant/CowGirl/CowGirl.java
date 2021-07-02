package Unit.Servant.CowGirl;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class CowGirl extends Servant {
    static int initHP = 200;
    static int initATK = 100;
    static int initDEF = 30;
    static BufferedImage Overview;
    static {
        try {
            Overview = ImageIO.read(new File("Assets/Servant/" + ServantName() + "/overview.png"));
        } catch (Exception e) {

        }
    }
    public CowGirl(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new CowGirlState(), world);
        this.stateControl.s = this;
        this.stride = 10;
        this.setNormalAttack(1, 500, 0, true, false);
    }

    @Override
    public BufferedImage toImage() {
        return Overview;
    }
    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return new CowGirl(new Point(coordinate), Camp, world);
    }
    
    static public String ServantName() {
        return "CowGirl";
    }
    
    static int cost = 300;

    @Override
    public int getCost() {
        return cost;
    }
}
