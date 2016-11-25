package sengoku_conquest.scene.command;

import sengoku_conquest.GameEngine;
import sengoku_conquest.character.EnemyCharacter;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class EscapeCommand extends BattleCommandHandler {
    private GameEngine engine=GameEngine.current;

    @Override
    protected Boolean execute(EnemyCharacter parameter) {
        return askEscape();
    }

    @Override
    public String getCommandName() {
        return "逃走";
    }

    private boolean askEscape(){
        engine.showMessage("本当に逃走しますか?");
        final int input=engine.readNumber(2);

        if(input==-1){
            engine.showMessage("入力に誤りがあります。");
            return askEscape();
        }

        return input == 1;
    }
}
