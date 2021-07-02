package Player;

import java.awt.image.*;

public abstract class Item {
    int price = 0;
    protected String description = "No effect!\n";

    public int getPrice() {
        return this.price;
    }
    public String getDescription() {
        return this.description;
    }

    public abstract void onGet(Player p);

    public abstract void onLost(Player p);

    public abstract BufferedImage toImage();
}
