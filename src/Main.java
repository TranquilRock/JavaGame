import javax.swing.*;

import BasicObject.MyButton;

import GameScene.*;
import Player.*;

public class Main {
    public static void main(String[] args) {
        JFrame monitor = new JFrame();
        monitor.getContentPane().setLayout(null);
        monitor.setBounds(-10, 0, Screen.width, Screen.height);
        monitor.setVisible(true);
        monitor.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Player player = new Player();
        MyButton.Init(monitor, player);
        ScreenController gameflow = new ScreenController(monitor,player);
        gameflow.start();
    }
}