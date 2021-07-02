package Unit.Servant.Knight;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Knight extends Servant {
    static int initHP = 2000;
    static int initATK = 200;
    static int initDEF = 10;
    static BufferedImage Overview;
    static {
        try {
            Overview = ImageIO.read(new File("Assets/Servant/" + ServantName() + "/overview.png"));
        } catch (Exception e) {

        }
    }

    public Knight(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, initHP, initATK, initDEF, new KnightState(), world);
        this.stride = 10;
        this.stateControl.s = this;
        this.setNormalAttack(1, 100, 0, true, false);
    }

    public Knight(Game world) {
        super(initHP, initATK, initDEF, new KnightState(), world);
        this.stateControl.s = this;
    }

    @Override
    public BufferedImage toImage() {
        return Overview;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return new Knight(new Point(coordinate), Camp, world);
    }

    static public String ServantName() {
        return "Knight";
    }

    @Override
    public int getCost() {
        return 0;// This is enemy
    }
}