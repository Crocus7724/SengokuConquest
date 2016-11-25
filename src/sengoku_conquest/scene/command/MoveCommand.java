package sengoku_conquest.scene.command;

import java.util.HashMap;
import java.util.Map;

import sengoku_conquest.GameEngine;
import sengoku_conquest.map.Area;
import sengoku_conquest.scene.AreaScene;

/**
 * Created by C011457331 on 2016/11/25.
 */
public class MoveCommand extends AreaCommandHandler{
    private GameEngine engine=GameEngine.current;
    private Area area;

    GameEngine gm = new GameEngine();

    @Override
    protected Boolean execute(Area parameter) {
        if(parameter.getAreaNum()>=0){
            selectMoveCommand();
        }
        return null;
    }

    private int selectMoveCommand() {
        Map<Integer, String> map = new HashMap<>();
        int i = 1;

        if (area.getNextAreaInfo().getEast() != -1) {

            engine.showMessage(i+":東");
            map.put(i,"E");
            i++;
        }
        if (area.getNextAreaInfo().getNorth() != -1) {
            engine.showMessage(i+":北");
            map.put(i,"N");
            i++;
        }
        if (area.getNextAreaInfo().getSouth() != -1) {
            engine.showMessage(i+":南");
            map.put(i,"S");
            i++;
        }
        if (area.getNextAreaInfo().getWest() != -1) {
            engine.showMessage(i+":西");
            map.put(i,"W");
            i++;
        }
        java.lang.String input = engine.readLineFromUserInput();
        if(input == null){
            engine.showMessage("コマンドを入力しなおしてください");
            selectMoveCommand();
        }
        if(input.isEmpty()|| !input.matches("[0-9]")){
            engine.showMessage("入力が不正です");
            selectMoveCommand();
        }
        int num = Integer.parseInt(input);
        if(num<0 &&num>=i)     {
            String s = map.get(num);
            if(s.equals("E")){
                return area.getNextAreaInfo().getEast();
            }else if(s.equals("N")){
                return area.getNextAreaInfo().getNorth();
            }else if(s.equals("S")){
                return area.getNextAreaInfo().getSouth();
            }else {
                return area.getNextAreaInfo().getWest();
            }

        }
        engine.showMessage("値が不正です");
        return selectMoveCommand();
    }

}
