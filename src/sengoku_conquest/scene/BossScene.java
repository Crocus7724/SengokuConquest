package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.BossCharacter;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;
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
        if (GameApplication.current.getMainCharacter().getLevel() <= Consts.BOSS_CHALLENGE_LEVEL_CONDITION) {
            GameEngine.current.showMessage(Strings.INVALID_BOSS_CHALLENGE);
            GameApplication.current.previousScene();
            return;
        }

        engine.showMessage(boss.getName() + Strings.BOSS_EXISTS);
        engine.showMessage(boss.getName() + Strings.BOSS_CHALLENGE);
        engine.showMessage("1 : "+Strings.YES);
        engine.showMessage("2 : "+Strings.NO);
        final int input = engine.readNumber(2);

        if (input == -1) {
            engine.showMessage(Strings.INVALID_INPUT);
            start();
            return;
        }

        if (input == 2) {
            GameApplication.current.previousScene();
            return;
        }

        engine.showMessage(boss.getName()+Strings.APPEAR_ENEMY);
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
        GameEngine.current.showBar(Strings.ENEMY_HP+" : ", boss.getStatus().getMaxHp(), boss.getStatus().getCurrentHp());
        engine.showMessage(Strings.SELECT_COMMAND);

        for (int i = 0; i < commandList.size(); i++) {
            engine.showMessage(i+1+" : "+commandList.get(i).getCommandName());
        }

        final int input = engine.readNumber(commandList.size());

        if(input==-1){
            engine.showMessage(Strings.INVALID_INPUT);
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
