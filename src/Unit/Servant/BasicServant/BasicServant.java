package Unit.Servant.BasicServant;

import Unit.*;
import Unit.Servant.Servant;
import GameScene.Game;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class BasicServant extends Servant {
    static int initHP = 10;
    static int initATK = 10;
    static int initDEF = 10;
    static BufferedImage Overview;
    static {
        try {
            Overview = ImageIO.read(new File("Assets/Servant/" + ServantName() + "/overview.png"));
        } catch (Exception e) {

        }
    }

    public BasicServant(Game world) {
        super(initHP, initATK, initDEF, new BasicServantState(), world);
        this.stateControl.s = this;
    }

    @Override
    public BufferedImage toImage() {
        return Overview;
    }

    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return null;
    }

    static public String ServantName() {
        return "BasicSeverant";
    }

    @Override
    public int getCost() {
        return 0;
    }
}
