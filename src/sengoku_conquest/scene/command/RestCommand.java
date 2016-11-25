package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.map.Area;

/**
 * Created by C0114105 on 2016/11/25.
 */
public class RestCommand extends AreaCommandHandler {
    private GameEngine engine = GameEngine.current;
    private MainCharacter character ;
    public int recoverHp;
    private boolean result;

    @Override
    protected Boolean execute(Area parameter) {
        return askRest();
    }

    private boolean askRest(){
        engine.showMessage("1ターン消費してHPを30回復します。よろしいですか？");
        engine.showMessage("1:休憩する　2:やめる");
        final int input = engine.readNumber(2);

        if(input==-1){
            engine.showMessage("入力が不正です");
            return askRest();
        }

        if(input==1){
            this.recoverHp = 30;
            int HP = character.getStatus().getCurrentHp()+recoverHp;

            if(HP>character.getStatus().getMaxHp()){
                HP = character.getStatus().getMaxHp();
            }
            character.getStatus().setCurrentHp(HP);
            GameApplication.current.decreaseTurn();
            result = true;
        }

        if(input==2){
            result = false;
        }

        return result;
    }



}
