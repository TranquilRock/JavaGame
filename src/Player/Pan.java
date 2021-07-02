package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import java.io.*;

public class Pan extends Item {
    private static BufferedImage img;
    private static String name = "Pan";
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/" + name + ".jpg")));
        } catch (Exception e) {
            System.out.print(name + "\n");
        }
    }

    public Pan() {
        super();
        this.price = 1000;
        this.description = "It can cook good meal~";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void onGet(Player p) {
    }

    @Override
    public void onLost(Player p) {
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
