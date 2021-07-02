package GameScene;

import javax.swing.JFrame;

import Player.Player;

// import java.awt.Component.*;
import java.awt.event.*;

public class ScreenController {
    private JFrame mainScreen;
    private Player player;

    public ScreenController(JFrame mainScreen, Player player) {
        this.mainScreen = mainScreen;
        this.player = player;
    }

    public void start() {
        HomePage menu = new HomePage(mainScreen);
        menu.run();
        int status = 0;
        Confront confront = new Confront(mainScreen, player);
        confront.run();
        Map gameMap = new Map(mainScreen);
        while (!gameMap.GameOver() && status >= 0) {
            gameMap.run();
            this.player.stage++;
            Screen nextScreen = gameMap.nextScreen;
            status = nextScreen.run();
            if (status > 0) {
                player.Win();
            }
        }
        if (status >= 0) {
            End endScene = new End(mainScreen);
            endScene.run();
        } else {
            Lose loseScene = new Lose(mainScreen);
            loseScene.run();
        }
        try {
            java.lang.Thread.sleep(3000);
        } catch (Exception e) {

        } finally {
            mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));
        }
    }
}
