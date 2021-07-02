package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;

import Unit.Servant.Servant;

import java.io.*;

public class Sword extends Item {
    private static BufferedImage img;
    private static String name = "Sword";
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/" + name + ".jpg")));
        } catch (Exception e) {
            System.out.print(name + "\n");
        }
    }

    public Sword() {
        super();
        this.price = 100;
        this.description = "Add 10 ATK to your Servants.";
    }

    @Override
    public String toString() {
        return Sword.name;
    }

    @Override
    public void onGet(Player p) {
        for(Servant s : p.Servants()){
            s.addATK(10);
        }
    }

    @Override
    public void onLost(Player p) {
        for (Servant s : p.Servants()) {
            s.addATK(-10);
        }
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
