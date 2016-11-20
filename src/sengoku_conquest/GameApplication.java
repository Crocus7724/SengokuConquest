package sengoku_conquest;

import java.util.*;

import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.item.Item;
import sengoku_conquest.map.Area;
import sengoku_conquest.map.BossArea;
import sengoku_conquest.map.EmptyArea;
import sengoku_conquest.scene.Scene;
import sengoku_conquest.scene.StartScene;
import sengoku_conquest.utilities.MappingData;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class GameApplication {
    private Random random=new Random();
    private List<Scene> sceneList = new ArrayList<>();

    private int turn;
    public static final GameApplication current = new GameApplication();
    private MainCharacter mainCharacter;

    public void gameStart() {

        createMapData();

        nextScene(new StartScene());
    }

    Map<Integer, Area> map = new HashMap<Integer, Area>();

    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public void nextScene(Scene scene) {
        if (!sceneList.isEmpty()) {
            sceneList.get(sceneList.size() - 1).doEnd();
        }
        sceneList.add(scene);
        scene.doStart();
    }

    public void previousScene() {
        final Scene scene = sceneList.get(sceneList.size() - 2);
        scene.doRestart();
    }

    public void decreaseTurn() {
        this.turn--;
    }

    public void increaseTurn(int num) {
        this.turn += num;
    }

    public int getTurn() {
        return turn;
    }

    private void createMapData() {
        Area[] areaList = MappingData.createArea();

        Area bossArea = areaList[14 - 1];
        map.put(14, new BossArea(bossArea.getAreaNum(), bossArea.getAreaName(), bossArea.getNextAreaInfo()));

        //ボスマス周り初期化
        for (int i = 12; i < 20; i++) {
            if (!map.containsKey(i)) {
                Area area = areaList[i - 1];
                map.put(i, new EmptyArea(area.getAreaNum(), area.getAreaName(), area.getNextAreaInfo()));
            }
        }

        //TODO : Itemマップ初期化
        //TODO : Enemyエリア初期化

        //空エリア初期化
        for (Area area : areaList){
            if(!map.containsKey(area.getAreaNum()))continue;

            map.put(area.getAreaNum(),new EmptyArea(area.getAreaNum(),area.getAreaName(),area.getNextAreaInfo()));
        }
    }

    private EnemyCharacter getEnemy(){
        //TODO : Enemyの初期化
        return null;
    }

    private Item getItem(){
        //TODO : Itemの初期化
        return null;
    }

    private int createNotContainsKey(int start,int end){
        final int i = random.nextInt(end - start) + start;

        if(!map.containsKey(i))return i;

        return createNotContainsKey(start,end);
    }
}



