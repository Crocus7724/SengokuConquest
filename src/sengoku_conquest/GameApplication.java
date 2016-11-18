package sengoku_conquest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.map.Area;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class GameApplication {
    public static final GameApplication current = new GameApplication();
    private MainCharacter mainCharacter;

    public void gameStart() {

    }

    Map<Integer, Area> map = new HashMap<Integer, Area>();

    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }
}



