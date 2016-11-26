package sengoku_conquest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.sun.xml.internal.bind.v2.util.CollisionCheckStack;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.item.Item;
import sengoku_conquest.map.*;
import sengoku_conquest.scene.EndScene;
import sengoku_conquest.scene.Scene;
import sengoku_conquest.scene.StartScene;
import sengoku_conquest.utilities.EnemyData;
import sengoku_conquest.utilities.MappingData;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class GameApplication {
    private Random random = new Random((long) (Math.random() * 1000));
    private List<Scene> sceneList = new ArrayList<>();
    private int turn = 0;
    private int count;
    public static final GameApplication current = new GameApplication();
    private MainCharacter mainCharacter;

    public void gameStart() {
        increaseTurn(30);
        createMapData();

        nextScene(new StartScene());
    }

    private Map<Integer, Area> map = new HashMap<Integer, Area>();

    public MainCharacter getMainCharacter() {
        return mainCharacter;
    }

    public void setMainCharacter(MainCharacter mainCharacter) {
        this.mainCharacter = mainCharacter;
    }

    public Map<Integer, Area> getMap() {
        return map;
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
        if (turn == 0) {
            nextScene(new EndScene());
        }
    }

    public void increaseTurn(int num) {
        this.turn += num;
    }

    public int getTurn() {
        return turn;
    }

    private void createMapData() {
        Area[] areaList = MappingData.createArea();

        //スタートエリア初期化
        Area startArea = areaList[17 - 1];
        map.put(17, new EmptyArea(startArea.getAreaNum(), startArea.getAreaName(), startArea.getNextAreaInfo()));
        startArea = areaList[16 - 1];
        map.put(16, new EmptyArea(startArea.getAreaNum(), startArea.getAreaName(), startArea.getNextAreaInfo()));

        createItemArea(areaList);

        //ボスエリア初期化
        Area bossArea = areaList[14 - 1];
        map.put(14, new BossArea(bossArea.getAreaNum(), bossArea.getAreaName(), bossArea.getNextAreaInfo()));

        //ボスマス周り初期化
        for (int i = 12; i < 20; i++) {
            if (!map.containsKey(i)) {
                Area area = areaList[i - 1];
                map.put(i, new EmptyArea(area.getAreaNum(), area.getAreaName(), area.getNextAreaInfo()));
            }
        }

        createEnemyArea(areaList);

        //空エリア初期化
        for (Area area : areaList) {
            if (map.containsKey(area.getAreaNum())) continue;

            map.put(area.getAreaNum(), new EmptyArea(area.getAreaNum(), area.getAreaName(), area.getNextAreaInfo()));
        }
    }

    private void createItemArea(Area[] areaList) {
        int key = createNotContainsKey(2, 11);
        Area itemArea = areaList[key - 1];
        map.put(itemArea.getAreaNum(), new ItemArea(itemArea.getAreaNum(), itemArea.getAreaName(), itemArea.getNextAreaInfo()));
        key = createNotContainsKey(12, 18);
        itemArea = areaList[key - 1];
        map.put(itemArea.getAreaNum(), new ItemArea(itemArea.getAreaNum(), itemArea.getAreaName(), itemArea.getNextAreaInfo()));
        key = createNotContainsKey(20, 25);
        itemArea = areaList[key - 1];
        map.put(itemArea.getAreaNum(), new ItemArea(itemArea.getAreaNum(), itemArea.getAreaName(), itemArea.getNextAreaInfo()));
    }

    private void createEnemyArea(Area[] areaList) {
        final EnemyData[] enemies = MappingData.createEnemies();

        for (EnemyData data : enemies) {
            int key = 0;
            if (data.popMax == data.popMin) {
                key = data.popMax;
            } else {
                key = createNotContainsKey(data.popMin, data.popMax);
            }
            Area area = areaList[key-1];
            map.put(area.getAreaNum(), new EnemyArea(data.enemy, area.getAreaNum(), area.getAreaName(), area.getNextAreaInfo()));
        }
    }

    private int createNotContainsKey(int start, int end) {
        try {
            if (count > 100) {
                for (int i=start;i<=end;i++){
                    if(!map.containsKey(i)){
                        return i;
                    }
                }
                throw new IllegalStateException();
            }

            final int i = (int) (Math.random() * (end - start)) + start;

            if (!map.containsKey(i)) {
                count = 0;
                return i;
            }

            count++;
            return createNotContainsKey(start, end);
        }catch (StackOverflowError error){
            System.out.println(start+" : "+end);
        }

        return createNotContainsKey(start,end);
    }
}



