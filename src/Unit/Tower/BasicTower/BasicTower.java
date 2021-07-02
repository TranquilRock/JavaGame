package Unit.Tower.BasicTower;

import Unit.Tower.Tower;

import java.awt.*;

import GameScene.Game;
import Unit.*;
import java.awt.image.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;

public class BasicTower extends Tower {
    // Should be encapsulated;
    private static Vector<BufferedImage> img = new Vector<BufferedImage>();
    private static final int nIdleImage = 1;
    static {
        for (int i = 1; i <= nIdleImage; i++) {
            try {
                img.add(ImageIO.read(new File("Assets/Tower/BasicTower/Idle/" + String.valueOf(i) + ".png")));
            } catch (Exception e) {
            }
        }
    }
    private int imgCounter = 0;
    private Dimension size = new Dimension(300, 400);

    public BasicTower() {
        super(1000, 10);
    }

    @Override
    public BufferedImage toImage() {
        // Unuse
        return null;
    }

    public void slice(Graphics g) {// Vector<Unit> target
        g.drawImage(img.get(imgCounter), this.coordinate.x, 200 + this.coordinate.y, size.width,
                size.height, null);
        imgCounter++;
        (imgCounter) %= nIdleImage;
    }

    public BasicTower(Point coordinate, boolean Camp, Game world) {
        super(coordinate, Camp, 1000, 10, world);
    }

    @Override
    public Unit Duplicate(Game world, Point coordinate, boolean Camp) {
        return (Unit) (new BasicTower(coordinate, Camp, world));
    }
}
