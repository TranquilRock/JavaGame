package GameScene;

import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;

import java.util.*;

public class Map extends Screen {
	private static int stage = 0;
	private static final int endStage = 4;
	private static Vector<Vector<Point>> location = new Vector<Vector<Point>>();
	private boolean gameOver = false;
	public Screen nextScreen = null;
	public static int charCount = 2;

	static {
		location.add(new Vector<Point>());
		location.get(0).add(new Point(330, 500));
		location.get(0).add(new Point(450, 580));
		location.add(new Vector<Point>());
		location.get(1).add(new Point(405, 170));
		location.get(1).add(new Point(545, 400));
		location.get(1).add(new Point(1080, 430));
		location.add(new Vector<Point>());
		location.get(2).add(new Point(740, 120));
		location.get(2).add(new Point(770, 270));
		location.get(2).add(new Point(1000, 210));
		location.add(new Vector<Point>());
		location.get(3).add(new Point(890, 100));
	}

	public Map(JFrame sharedScreen) {
		super(sharedScreen);
		layeredPane.setLayout(null);
		setBackground();
		setButtons();
		screen.setContentPane(layeredPane);
	}

	public boolean GameOver() {
		if (endStage <= stage) {
			gameOver = true;
		}
		return gameOver;
	}

	private void setBackground() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/map.png"));
		} catch (Exception e) {
			System.out.println("No image!");
		}
		Image resized = img.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);

		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());

		layeredPane.add(imgLabel, 0);
	}

	private void setButtons() {
		Dimension buttonSize = new Dimension(100, 100);
		if (stage == 3) {
			JButton b = MyButton.setGameButton("Battle", location.get(3).get(0), buttonSize, this);
			layeredPane.add(b, 0);
			layeredPane.moveToFront(b);
		} else {
			for (int z = 0; z < location.get(stage).size(); z++) {
				int r = (int) (Math.random() * 400);
				if (r < 70 && charCount > 0) {
					JButton b = MyButton.setConfrontButton("!?!", location.get(stage).get(z), buttonSize, this);
					layeredPane.add(b, 0);
					layeredPane.moveToFront(b);

				} else if (r < 300) {
					JButton b = MyButton.setGameButton("Battle", location.get(stage).get(z), buttonSize, this);
					layeredPane.add(b, 0);
					layeredPane.moveToFront(b);
				} else {
					JButton b = MyButton.setShopButton("Shop", location.get(stage).get(z), buttonSize, this);
					layeredPane.add(b, 0);
					layeredPane.moveToFront(b);
				}
			}
		}
	}

	@Override
	public void end() {
		super.running = false;
		Map.stage++;
		if (Map.stage < Map.endStage) {
			// this.screen.removeAll();
			// this.screen.validate();
			// this.screen.repaint();
			this.screen.getContentPane().removeAll();
			this.setBackground();
			this.setButtons();
			this.screen.setContentPane(layeredPane);
		}
	}

	public int curStage() {
		return Map.stage;
	}
}