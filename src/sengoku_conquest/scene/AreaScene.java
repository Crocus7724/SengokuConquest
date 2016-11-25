package sengoku_conquest.scene;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import sengoku_conquest.character.Character;
import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.item.EpItem;
import sengoku_conquest.item.HpItem;
import sengoku_conquest.item.Item;
import sengoku_conquest.map.Area;
import sengoku_conquest.map.EmptyArea;
import sengoku_conquest.map.ItemArea;
import sengoku_conquest.map.NextAreaInfo;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class AreaScene extends Scene{
    private Area area;
    private GameEngine engine;
    private MainCharacter character;
    AreaScene(Area area){
        this.area = area;
        this.engine = new GameEngine();


    }

    @Override
    void start() {
        if(area instanceof EmptyArea){
        waitPlayerCommand();
        }else if (area instanceof ItemArea){

        }
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }
    private void waitPlayerCommand() {
        engine.showMessage("コマンドを入力なさってください");
        boolean hasitem = false;
        engine.showMessage("1:移動");
        engine.showMessage("2:休憩");
        if(!GameApplication.current.getMainCharacter().getItems().isEmpty()) {
            engine.showMessage("3:アイテム");
            hasitem = true;
        }
        java.lang.String input = engine.readLineFromUserInput();
        if(input == null){
            engine.showMessage("コマンドを入力しなおしてください");
            waitPlayerCommand();
        }
        if(input.isEmpty()|| !input.matches("[0-9]")){
            engine.showMessage("入力が不正です");
            waitPlayerCommand();
        }
        int num = Integer.parseInt(input);
        if(num>0 &&num<(hasitem ? 4:3))     {
            switch (num){
                case 1:
                    selectMoveCommand();
                case 2:
                    selctLestCommand();
                case 3:
                    selectItemCommand();

            }
        }

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

    public int recoveryHP = 30;
    private void selctLestCommand(){//HPを回復するメソッドです
        int hp  = character.getStatus().getCurrentHp() + recoveryHP;


        if(hp > character.getStatus().getMaxHp()) {
            hp = character.getStatus().getMaxHp();
        }

        character.getStatus().setCurrentHp(hp);
        GameApplication.current.decreaseTurn();
        //↑これで現在のターンから1ターン減算することができているでしょうか
    }

    private void selectItemCommand(){
        GameApplication.current.getMainCharacter().getItems();
        HpItem Hpitem = new HpItem();
        EpItem Epitem = new EpItem();
            engine.showMessage("1" + Hpitem.getName());

            engine.showMessage("2" + Epitem.getName());

        java.lang.String input = engine.readLineFromUserInput();
        if(input==null){
            engine.showMessage("コマンドを入力しなおしてください");
            selectMoveCommand();
        }
        if(input.isEmpty()||!input.matches("[0-9]")){
            engine.showMessage("入力が不正です");
            selectItemCommand();
        }
        int num = Integer.parseInt(input);
        if(0<num && num<3){
            switch (num){
                case 1:
                    Hpitem.useItem(GameApplication.current.getMainCharacter());


                case 2:
                    Epitem.useItem(GameApplication.current.getMainCharacter());
            }
        }



    }
}





