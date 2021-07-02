package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import java.io.*;
import Unit.Servant.*;

public class Shoes extends Item {
    private static BufferedImage img;
    private static String name = "Shoes";
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/" + name + ".jpg")));
        } catch (Exception e) {
            System.out.print(name + "\n");
        }
    }

    public Shoes() {
        super();
        this.price = 130;
        this.description = "Add 5 speed to your Servants.";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void onGet(Player p) {
        for (Servant s : p.Servants()) {
            s.addStride(5);
        }
    }

    @Override
    public void onLost(Player p) {
        for (Servant s : p.Servants()) {
            s.addStride(-5);
        }
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
