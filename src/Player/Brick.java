package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import java.io.*;

public class Brick extends Item {
    private static BufferedImage img;
    private static String name = "Brick";
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/" + name + ".jpg")));
        } catch (Exception e) {
            System.out.print(name + "\n");
        }
    }

    public Brick() {
        super();
        this.price = 70;
        this.description = "Add 30 DEF to your Tower.";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void onGet(Player p) {
        p.MyTower().addDef(30);
    }

    @Override
    public void onLost(Player p) {
        p.MyTower().addDef(-30);
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
