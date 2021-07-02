package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import java.io.*;
import Unit.Servant.*;

public class Cake extends Item {
    private static BufferedImage img;
    private static String name = "Cake";
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/" + name + ".jpg")));
        } catch (Exception e) {
            System.out.print(name + "\n");
        }
    }

    public Cake() {
        super();
        this.price = 90;
        this.description = "Add 100 HP to your Servants.";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void onGet(Player p) {
        for (Servant s : p.Servants()) {
            s.addHP(100);
        }
    }

    @Override
    public void onLost(Player p) {
        for (Servant s : p.Servants()) {
            s.addHP(-100);
        }
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
