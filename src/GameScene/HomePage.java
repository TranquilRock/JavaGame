package GameScene;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;

public class HomePage extends Screen {
	public HomePage(JFrame currentScreen) {
		super(currentScreen);
		setBackground();
		setTitle();
		setButton();
		screen.setContentPane(layeredPane);
	}

	private void setTitle() {
		JLabel title = new JLabel("Game", JLabel.CENTER);
		title.setBounds(570, 300, 400, 200);
		title.setFont(new Font("Serif", Font.ITALIC + Font.BOLD, 150));
		title.setForeground(Color.white);
		title.setBackground(Color.blue);
		title.setOpaque(true);
		title.setBorder(BorderFactory.createLineBorder(Color.orange, 5));
		layeredPane.add(title, 1);
		layeredPane.moveToFront(title);
	}

	private void setButton() {
		Dimension buttonSize = new Dimension(200, 120);
		int posY = 585;
		JButton easy = MyButton.setDifficultyButton("Easy", new Point(220, posY), buttonSize, 1, this);
		easy.setBorder(BorderFactory.createLineBorder(Color.green, 2));
		layeredPane.add(easy);
		layeredPane.moveToFront(easy);
		JButton medium = MyButton.setDifficultyButton("Medium", new Point(670, posY), buttonSize, 2, this);
		medium.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
		layeredPane.add(medium);
		layeredPane.moveToFront(medium);
		JButton hard = MyButton.setDifficultyButton("Hard", new Point(1120, posY), buttonSize, 3, this);
		hard.setBorder(BorderFactory.createLineBorder(Color.red, 2));
		layeredPane.add(hard);
		layeredPane.moveToFront(hard);
	}

	private void setBackground() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/homepage.png"));
		} catch (Exception e) {
			System.out.println("No homepage image!");
		}
		Image resized = img.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);

		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		layeredPane.add(imgLabel, 0);
	}
}