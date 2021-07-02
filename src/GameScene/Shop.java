package GameScene;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import BasicObject.*;
import Player.*;

public class Shop extends Screen {
	public static final int nAvailable = 6;
	private JLabel account = null;
	private boolean buy = false;
	private static Vector<Item> allItem = new Vector<Item>();
	static {
		allItem.add(new Soup());
		allItem.add(new Shoes());
		allItem.add(new Cake());
		allItem.add(new Pan());
		allItem.add(new Sword());
		allItem.add(new Brick());
		allItem.add(new Armor());
	}
	private Player player;

	public Shop(JFrame sharedScreen, Player player) {
		super(sharedScreen);
		this.player = player;
		layeredPane.setLayout(null);		
		setBackground();
		setBackButton();
		setShelves();		
		setAccountBalance();
		screen.setContentPane(layeredPane);
	}

	public void Buy() { this.buy = true;}

	private Item PickItem() {
		return allItem.get((int) (Math.random() * allItem.size()));
	}

	private void setBackButton() {
		JButton backButton = MyButton.exitButton("Back", new Point(1260, 740), new Dimension(100, 43), this);
		backButton.setFont(new Font("Dialog", Font.BOLD, 28));
		layeredPane.add(backButton, 0);
		layeredPane.moveToFront(backButton);
	}

	private void setAccountBalance() {
		String str = "<html><body>" + "Account Balance:" + "<br>" + String.valueOf(player.getGold()) + "<body></html>";
		account = new JLabel(str, JLabel.CENTER);
		account.setBounds(225, 210, 135, 160);
		account.setBackground(Color.BLUE);
		account.setForeground(Color.YELLOW);
		account.setOpaque(true);
		account.setFont(new Font("DialogInput", Font.BOLD, 26));
		layeredPane.add(account);
		layeredPane.moveToFront(account);
	}

	private void setBackground() {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Assets/shop.jpg"));
		} catch (Exception e) {
			System.out.println("No image!");
		}
		BufferedImage subImg = img.getSubimage(80, 0, 1400, img.getHeight());
		Image resized = subImg.getScaledInstance(Screen.width, Screen.height, Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(resized);
		JLabel imgLabel = new JLabel(image);
		imgLabel.setBounds(0, 0, image.getIconWidth(), image.getIconHeight());
		layeredPane.add(imgLabel, 0);

		JLabel title = new JLabel("Shop", JLabel.CENTER);
		title.setBounds(225, 67, 133, 50);
		title.setFont(new Font("Dialog", Font.BOLD, 42));
		title.setForeground(Color.orange);
		title.setOpaque(true);
		title.setBackground(Color.darkGray);
		layeredPane.add(title, 0);
		layeredPane.moveToFront(title);
	}

	private void setShelves() {
		Dimension shelfSize = new Dimension(420, 160);
		Dimension buttonSize = new Dimension(420, 60);
		Point[] location = { new Point(410, 60), new Point(858, 60), new Point(410, 300), new Point(858, 300),
				new Point(410, 540), new Point(858, 540) };
		for (int i = 0; i < nAvailable; i++) {
			JLabel backLabel = new JLabel();
			backLabel.setLocation(location[i]);
			backLabel.setSize(shelfSize);
			backLabel.setBackground(Color.magenta);
			backLabel.setOpaque(true);
			layeredPane.add(backLabel, 0);
			layeredPane.moveToFront(backLabel);
		}

		for (int i = 0; i < nAvailable; i++) {
			Item t = PickItem();
			BufferedImage image = t.toImage();
			Image resized = image.getScaledInstance(420, 160, Image.SCALE_SMOOTH);
			JLabel imgLabel = new JLabel(new ImageIcon(resized));
			imgLabel.setBounds(location[i].x, location[i].y, shelfSize.width, shelfSize.height);
			layeredPane.add(imgLabel, 0);
			layeredPane.moveToFront(imgLabel);
			JButton tButton = MyButton.buyItemButton(
					t.toString() + " $" + String.valueOf(t.getPrice()) + ". " + t.getDescription(),
					new Point(location[i].x, location[i].y + 160), buttonSize, t, this);
			layeredPane.add(tButton, 0);
			layeredPane.moveToFront(tButton);
		}
	}

	@Override
	public void runningEvent() {
		if (buy == true) {
			buy = false;
			account.setText("<html><body>" + "Account Balance:" + "<br>" + String.valueOf(player.getGold()) + "<body></html>");
		}
	}
}
