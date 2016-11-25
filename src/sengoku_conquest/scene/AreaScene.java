package sengoku_conquest.scene;


import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.item.Item;
import sengoku_conquest.map.Area;
import sengoku_conquest.map.BossArea;
import sengoku_conquest.map.EnemyArea;
import sengoku_conquest.map.ItemArea;
import sengoku_conquest.scene.command.AreaCommandHandler;
import sengoku_conquest.scene.command.MoveCommand;
import sengoku_conquest.scene.command.RestCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class AreaScene extends Scene{
    private Area area;
    private GameEngine engine;
    private MainCharacter character;
    private List<AreaCommandHandler> commandList=new ArrayList<>();

    public AreaScene(Area area){
        this.area = area;
        this.engine = new GameEngine();

        commandList.add(new MoveCommand());
        commandList.add(new RestCommand());
    }

    @Override
    void start() {
        GameEngine.current.showMessage("現在位置 : "+area.getAreaNum());
        if (area instanceof ItemArea){
            getItemFromArea((ItemArea)area);
        }else if(area instanceof EnemyArea){
            final EnemyArea enemyArea = (EnemyArea) this.area;
            if(enemyArea.getEnemy().getStatus().getCurrentHp()>0) {
                GameApplication.current.nextScene(new BattleScene(enemyArea.getEnemy()));
            }
        }else if(area.getClass()==BossArea.class){
            GameApplication.current.nextScene(new BossScene());
            return;
        }

        selectCommand();
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }

    private void selectCommand(){
        engine.showMessage("コマンドを入力して下さい");

        for (int i=0;i<commandList.size();i++){
            engine.showMessage(i+1+" : "+commandList.get(i).getCommandName());
        }

        final int input = engine.readNumber(commandList.size());

        if(input==-1){
            selectCommand();
            return;
        }

        commandList.get(input-1).doExecute(area);
    }

    private void getItemFromArea(ItemArea area){
        final Item item = area.getItem();

        engine.showMessage(item.getName()+"を見つけた!!");

        GameApplication.current.getMainCharacter().getItems().add(item);
    }
}





