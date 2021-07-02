package GameScene;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;

public class Lose extends Screen {
    public Lose(JFrame sharedScreen) {
        super(sharedScreen);
        Image img = null;
        try {
            img = ImageIO.read(new File("Assets/lose.png")).getScaledInstance(Screen.width, Screen.height,
                    Image.SCALE_SMOOTH);
        } catch (Exception e) {
            System.out.println("No image!");
        }
        ImageIcon image = new ImageIcon(img);
        JLabel imgLabel = new JLabel(image);
        imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
        layeredPane.add(imgLabel, 0);
        screen.setContentPane(layeredPane);
    }

    @Override
    public void runningEvent() {
        this.end();
    }
}
