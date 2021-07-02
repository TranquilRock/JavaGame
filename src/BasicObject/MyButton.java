package BasicObject;

import Player.*;
import GameScene.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Unit.Servant.*;

public class MyButton {
    public static void Init(JFrame s, Player p) {
        MyButton.sharedScreen = s;
        MyButton.player = p;
    }

    private static JFrame sharedScreen = null;
    private static Player player = null;

    public static JButton setShopButton(String text, Point p, Dimension d, Map self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("Dialog", Font.BOLD, 24));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                self.nextScreen = new Shop(sharedScreen, player);
                self.end();
            }
        });
        return b;
    }

    public static JButton setGameButton(String text, Point p, Dimension d, Map self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("Dialog", Font.BOLD, 24));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                self.nextScreen = new Game(sharedScreen, player);
                self.end();
            }
        });
        return b;
    }

    public static JButton setConfrontButton(String text, Point p, Dimension d, Map self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.setFont(new Font("Dialog", Font.BOLD, 24));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Map.charCount--;
                self.nextScreen = new Confront(sharedScreen, player);
                self.end();
            }
        });
        return b;
    }

    public static JButton exitButton(String text, Point p, Dimension d, Screen self) {// Map
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setBackground(Color.darkGray);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(true);
        b.setForeground(Color.yellow);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                self.end();
            }
        });
        return b;
    }

    public static JButton setDifficultyButton(String text, Point p, Dimension d, int difficulty, Screen self) {// Homepage
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setFont(new Font("DialogInput", Font.BOLD, 44));
        b.setForeground(Color.white);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setHardness(difficulty);
                if (self != null) {
                    self.end();
                }
            }
        });
        return b;
    }

    public static JButton buyItemButton(String text, Point p, Dimension d, Item item, Shop self) {// Shop
        JButton b = null;
        b = new JButton(text);
        b.setFont(new Font("Dialog", Font.PLAIN, 16));
        b.setLocation(p);
        b.setSize(d);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!((JButton) e.getSource()).getText().equals("Sold!")) {
                    if (player.getGold() >= item.getPrice()) {
                        player.spent(item.getPrice());
                        player.addItem(item);
                        ((JButton) e.getSource()).setText("Sold!");
                        self.Buy();
                    } else {
                        ((JButton) e.getSource()).setText("NOT ENOUGH!!");
                    }
                }
            }
        });
        return b;
    }

    public static JButton setServant(String text, Point p, Dimension d, Game game, Servant servant) {// Game
        JButton b = null;
        b = new JButton(text);
        b.setLocation(p);
        b.setSize(d);
        b.setContentAreaFilled(false);
        b.setBorderPainted(true);
        b.setOpaque(false);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                game.addServant(servant);
            }
        });
        return b;
    }
}
