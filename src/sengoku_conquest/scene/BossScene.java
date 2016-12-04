package sengoku_conquest.scene;

import com.sun.corba.se.impl.activation.CommandHandler;
import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.BossCharacter;
import sengoku_conquest.map.BossArea;
import sengoku_conquest.scene.command.BattleCommandHandler;
import sengoku_conquest.scene.command.NormalAttackCommand;
import sengoku_conquest.scene.command.SpecialAttackCommand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class BossScene extends Scene{
    private BossCharacter boss;
    private List<BattleCommandHandler> commandList=new ArrayList<>();
    private GameEngine engine=GameEngine.current;

    public BossScene(BossArea area){
        this.boss= (BossCharacter) area.getEnemy();
        commandList.add(new NormalAttackCommand());
        commandList.add(new SpecialAttackCommand());
    }

    @Override
    void start() {
        if (GameApplication.current.getMainCharacter().getLevel() < 4) {
            GameEngine.current.showMessage("不思議なチカラで阻まれた!!");
            GameApplication.current.previousScene();
            return;
        }

        engine.showMessage("この先に" + boss.getName() + "がいます。");
        engine.showMessage(boss.getName() + "に挑みますか?");
        engine.showMessage("1 : はい");
        engine.showMessage("2 : いいえ");
        final int input = engine.readNumber(2);

        if (input == -1) {
            engine.showMessage("値が不正です");
            start();
            return;
        }

        if (input == 2) {
            GameApplication.current.previousScene();
            return;
        }

        engine.showMessage(boss.getName()+"が現れた!!");
        selectCommand();
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }

    private void selectCommand(){
        engine.showMainCharacterStatus();
        GameEngine.current.showBar("敵体力 : ", boss.getStatus().getMaxHp(), boss.getStatus().getCurrentHp());
        engine.showMessage("コマンドを選択して下さい");

        for (int i = 0; i < commandList.size(); i++) {
            engine.showMessage(i+1+" : "+commandList.get(i).getCommandName());
        }

        final int input = engine.readNumber(commandList.size());

        if(input==-1){
            engine.showMessage("値が不正です");
            selectCommand();
            return;
        }

        if (commandList.get(input-1).doExecute(boss)) {
            if(GameApplication.current.getMainCharacter().getStatus().getCurrentHp()<=0){
                GameApplication.current.nextScene(new EndScene());
            }else if(boss.getStatus().getCurrentHp()<=0) {
                GameApplication.current.nextScene(new EndScene());
            }
        }

        selectCommand();
    }

    private Map<String,String> get(){
        final Map<String, String> s = new HashMap<>();
        s.put("NAME",boss.getName());
        s.put("HP",boss.getStatus().getCurrentHp()+"");

        return s;
    }
}
