package Unit.Tower;

import Unit.*;
import GameScene.Game;
import java.awt.*;

public abstract class Tower extends Unit {
    public Tower(Point coordinate, Boolean Camp, int hp, int def, Game myWorld) {
        super(coordinate, Camp, hp, def, myWorld);
    }

    public Tower(int hp, int def) {
        super(hp, def);
    }

}