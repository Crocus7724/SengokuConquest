package sengoku_conquest;

import java.util.*;

import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.map.Area;
import sengoku_conquest.scene.Scene;
import sengoku_conquest.scene.StartScene;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class GameApplication {
    private List<Scene> sceneList =new ArrayList<>();
    public static final GameApplication current = new GameApplication();
    private MainCharacter mainCharacter;

    public void gameStart() {
        nextScene(new StartScene());
    }

    Map<Integer, Area> map = new HashMap<Integer, Area>();

    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public void nextScene(Scene scene){
        if(!sceneList.isEmpty()) {
            sceneList.get(sceneList.size() - 1).doEnd();
        }
        sceneList.add(scene);
        scene.doStart();
    }

    public void previousScene(){
        final Scene scene = sceneList.get(sceneList.size() - 2);
        scene.doRestart();
    }
}



