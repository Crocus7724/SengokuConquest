package sengoku_conquest.scene.command;

import java.util.HashMap;
import java.util.Map;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.const_values.Strings;
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
        return Strings.MOVE_COMMAND_NAME;
    }

    private int selectMoveCommand() {
        Map<Integer, String> map = new HashMap<>();
        int i = 0;

        if (area.getNextAreaInfo().getEast() != -1) {

            i++;
            engine.showCommandMessage(i, Strings.EAST);
            map.put(i, Strings.EAST);
        }
        if (area.getNextAreaInfo().getNorth() != -1) {
            i++;
            engine.showCommandMessage(i ,Strings.NORTH);
            map.put(i, Strings.NORTH);
        }
        if (area.getNextAreaInfo().getSouth() != -1) {
            i++;
            engine.showCommandMessage(i,Strings.SOUTH);
            map.put(i, Strings.SOUTH);
        }
        if (area.getNextAreaInfo().getWest() != -1) {
            i++;
            engine.showCommandMessage(i,Strings.WEST);
            map.put(i, Strings.WEST);
        }

        i++;
        engine.showCommandMessage(i,Strings.RETURN);

        int input = engine.readNumber(i);

        if (input == -1) {
            engine.showMessage(Strings.INVALID_INPUT);
            return selectMoveCommand();
        }

        String s = map.get(input);
        if (s == null && input == i) {
            return -1;
        } else if (s.equals(Strings.EAST)) {
            return area.getNextAreaInfo().getEast();
        } else if (s.equals(Strings.NORTH)) {
            return area.getNextAreaInfo().getNorth();
        } else if (s.equals(Strings.SOUTH)) {
            return area.getNextAreaInfo().getSouth();
        } else if(s.equals(Strings.WEST)) {
            return area.getNextAreaInfo().getWest();
        }
        return selectMoveCommand();
    }

}
