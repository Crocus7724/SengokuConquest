package sengoku_conquest.scene.command;

import java.util.HashMap;
import java.util.Map;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.map.Area;
import sengoku_conquest.scene.AreaScene;

/**
 * Created by C011457331 on 2016/11/25.
 */
public class MoveCommand extends AreaCommandHandler {
    private GameEngine engine = GameEngine.current;
    private Area area;

    GameEngine gm = new GameEngine();

    @Override
    protected Boolean execute(Area parameter) {
        this.area = parameter;

        final int nextAreaNumber = selectMoveCommand();
        if(nextAreaNumber == -1){
            return false;
        }

        GameApplication.current.nextScene(new AreaScene(GameApplication.current.getMap().get(nextAreaNumber)));
        return true;
    }

    @Override
    public String getCommandName() {
        return "移動";
    }

    private int selectMoveCommand() {
        Map<Integer, String> map = new HashMap<>();
        int i = 0;

        if (area.getNextAreaInfo().getEast() != -1) {

            i++;
            engine.showMessage(i + ":東");
            map.put(i, "E");
        }
        if (area.getNextAreaInfo().getNorth() != -1) {
            i++;
            engine.showMessage(i + ":北");
            map.put(i, "N");
        }
        if (area.getNextAreaInfo().getSouth() != -1) {
            i++;
            engine.showMessage(i + ":南");
            map.put(i, "S");
        }
        if (area.getNextAreaInfo().getWest() != -1) {
            i++;
            engine.showMessage(i + ":西");
            map.put(i, "W");
        }

        i++;
        engine.showMessage(i+"戻る");

        int input = engine.readNumber(i);

        if (input == -1) {
            engine.showMessage("値が不正です");
            return selectMoveCommand();
        }

        String s = map.get(input);
        if (s == null && input == i) {
            return -1;
        } else if (s.equals("E")) {
            return area.getNextAreaInfo().getEast();
        } else if (s.equals("N")) {
            return area.getNextAreaInfo().getNorth();
        } else if (s.equals("S")) {
            return area.getNextAreaInfo().getSouth();
        } else if(s.equals("W")) {
            return area.getNextAreaInfo().getWest();
        }
        return selectMoveCommand();
    }

}
