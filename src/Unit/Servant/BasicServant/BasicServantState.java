package Unit.Servant.BasicServant;

import Unit.Servant.State.State;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.util.*;
import java.awt.image.*;

public class BasicServantState extends State {
    private static final Dimension size = new Dimension(1, 1);
    private static Vector<BufferedImage> attackImage = new Vector<BufferedImage>();
    private static Vector<BufferedImage> deadImage = new Vector<BufferedImage>();
    private static Vector<BufferedImage> walkImage = new Vector<BufferedImage>();

    public BasicServantState() {
        nAttackImage = 0;
        for (int i = 1; i <= nAttackImage; i++) {
            try {
                attackImage.add(ImageIO
                        .read(new File("Assets/Servant/" + ServantName() + "/Attack/" + String.valueOf(i) + ".png")));
            } catch (IOException e) {
                System.out.print(
                        "Load" + "Assets/Servant/" + ServantName() + "/Attack/" + String.valueOf(i) + ".png Failed\n");
            }
        }
        nWalkImage = 0;
        for (int i = 1; i <= nWalkImage; i++) {
            try {
                walkImage.add(ImageIO
                        .read(new File("Assets/Servant/" + ServantName() + "/Walk/" + String.valueOf(i) + ".png")));
            } catch (IOException e) {
                System.out.print(
                        "Load" + "Assets/Servant/" + ServantName() + "/Walk/" + String.valueOf(i) + ".png Failed\n");
            }
        }
        nDeadImage = 0;
        for (int i = 1; i <= nDeadImage; i++) {
            try {
                deadImage.add(ImageIO
                        .read(new File("Assets/Servant/" + ServantName() + "/Dead/" + String.valueOf(i) + ".png")));
            } catch (IOException e) {
                System.out.print(
                        "Load" + "Assets/Servant/" + ServantName() + "/Dead/" + String.valueOf(i) + ".png Failed\n");
            }
        }
        range = new Rectangle(0, 0, size.width, size.height);
    }

    static public String ServantName() {
        return "BasicSeverant";
    }

    @Override
    protected BufferedImage attackImage(int index) {
        return attackImage.get(index);
    }

    @Override
    protected BufferedImage deadImage(int index) {
        return deadImage.get(index);
    }

    @Override
    protected BufferedImage walkImage(int index) {
        return walkImage.get(index);
    }
}
