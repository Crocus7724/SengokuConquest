package sengoku_conquest.scene.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    protected Boolean execute(Area parameter) {
        this.area = parameter;

        final int nextAreaNumber = selectMoveCommand();
        if (nextAreaNumber == -1) {
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
        List<String> map = new ArrayList<>();
        int i = 0;

        if (area.getNextAreaInfo().getEast() != -1) {
            engine.showCommandMessage(1, Strings.EAST);
            map.add(Strings.EAST);
        }
        if (area.getNextAreaInfo().getNorth() != -1) {
            engine.showCommandMessage(2, Strings.NORTH);
            map.add(Strings.NORTH);
        }
        if (area.getNextAreaInfo().getSouth() != -1) {
            engine.showCommandMessage(3, Strings.SOUTH);
            map.add(Strings.SOUTH);
        }
        if (area.getNextAreaInfo().getWest() != -1) {
            engine.showCommandMessage(4, Strings.WEST);
            map.add(Strings.WEST);
        }

        engine.showCommandMessage(5, Strings.RETURN);

        int input = engine.readNumber(5);

        if (input == -1) {
            engine.showMessage(Strings.INVALID_INPUT);
            return selectMoveCommand();
        }

        if (input == 1 && map.contains(Strings.EAST)) {
            return area.getNextAreaInfo().getEast();
        } else if (input == 2 && map.contains(Strings.NORTH)) {
            return area.getNextAreaInfo().getNorth();
        } else if (input == 3 && map.contains(Strings.SOUTH)) {
            return area.getNextAreaInfo().getSouth();
        } else if (input == 4 && map.contains(Strings.WEST)) {
            return area.getNextAreaInfo().getWest();
        } else if (input == 5) {
            return -1;
        }

        engine.showMessage(Strings.INVALID_INPUT);

        return selectMoveCommand();
    }

}
