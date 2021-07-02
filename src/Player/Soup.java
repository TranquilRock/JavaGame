package Player;

import java.awt.image.BufferedImage;
import javax.imageio.*;
import java.io.*;

public class Soup extends Item {
    static BufferedImage img;
    static {
        try {
            img = (ImageIO.read(new File("Assets/Item/Soup.jpg")));
        } catch (Exception e) {
            System.out.print("Soup\n");
        }
    }
    public Soup(){
        super();
        this.price = 30;
        this.description = "Add 100 HP to your Tower.";
    }
    @Override
    public String toString() {
        return "Soup";
    }
    
    @Override
    public void onGet(Player p) {
        p.MyTower().addHP(100);
    }

    @Override
    public void onLost(Player p) {
        p.MyTower().addHP(-100);
    }

    @Override
    public BufferedImage toImage() {
        return img;
    }
}
