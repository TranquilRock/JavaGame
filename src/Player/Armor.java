package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import Unit.Servant.Servant;

import java.io.*;

public class Armor extends Item {
    private static BufferedImage img;
    private static String name = "Armor";
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/" + name + ".jpg")));
        } catch (Exception e) {
            System.out.print(name + "\n");
        }
    }

    public Armor() {
        super();
        this.price = 200;
        this.description = "Add 20 DEF to your Servants.";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void onGet(Player p) {
        for (Servant s : p.Servants()) {
            s.addDef(20);
        }
    }

    @Override
    public void onLost(Player p) {
        for (Servant s : p.Servants()) {
            s.addDef(-20);
        }
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
