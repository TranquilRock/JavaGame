package GameScene;

import javax.swing.JFrame;

import Player.Player;

import java.util.*;
import java.awt.image.*;
import java.io.*;
import Unit.Servant.*;
import javax.imageio.*;
import Unit.Servant.CowGirl.*;
import Unit.Servant.MaleZombie.*;
import Unit.Servant.Ninja.*;

import java.awt.*;
import javax.swing.*;
import BasicObject.*;

public class Confront extends Screen {
    private static Vector<BufferedImage> Scene = new Vector<BufferedImage>();
    private static Vector<Servant> Partner = new Vector<Servant>();
    static {
        for (int i = 1; i <= 3; i++) {
            try {
                Scene.add(ImageIO.read(new File("Assets/scene" + String.valueOf(i) + ".jpg")));
            } catch (Exception e) {
                System.out.println("No image!");
            }
        }
        Partner.add(new CowGirl(new Point(0, 0), true, null));
        Partner.add(new Ninja(new Point(0, 0), true, null));
        Partner.add(new MaleZombie(new Point(0, 0), true, null));
        for (int y = 0; y < Scene.size(); y++) {
            for (int x = 0; x < Scene.size() - 1; x++) {
                for (int w = x + 1; w < Scene.size(); w++) {
                    if ((int) (Math.random() * 3) > 1) {
                        Collections.swap(Scene, x, w);
                        Collections.swap(Partner, x, w);
                    }
                }
            }
        }

    }
    private static int counter = 0;

    public Confront(JFrame sharedScreen, Player player) {
        super(sharedScreen);
        if (counter < Scene.size()) {
            layeredPane.setLayout(null);
            Image resized = Scene.get(counter).getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
            ImageIcon image = new ImageIcon(resized);
            JLabel imgLabel = new JLabel(image);
            imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
            layeredPane.add(imgLabel, 0);

            ImageIcon image2 = new ImageIcon(Partner.get(counter).toImage());

            JLabel imgLabel2 = new JLabel(image2);
            imgLabel2.setBounds(535, 200, 400, 700);
            layeredPane.add(imgLabel2, 1);
            layeredPane.moveToFront(imgLabel2);

            JLabel label = new JLabel("Let me join you!");
            label.setForeground(Color.white);
            label.setFont(new Font("Dialog", Font.BOLD, 60));
            label.setBounds(520, 85, 600, 100);
            layeredPane.add(label, 1);
            layeredPane.moveToFront(label);

            JButton b = MyButton.exitButton("Back", new Point(1120, 680), new Dimension(170, 80), this);
            b.setFont(new Font("DialogInput", Font.BOLD, 42));
            layeredPane.add(b, 0);
            layeredPane.moveToFront(b);
            screen.setContentPane(layeredPane);
            player.addMember(Partner.get(counter));
        }
        counter++;
    }

}
