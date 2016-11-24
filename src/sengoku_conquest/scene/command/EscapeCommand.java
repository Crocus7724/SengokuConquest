package sengoku_conquest.scene.command;

import sengoku_conquest.GameEngine;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class EscapeCommand extends CommandHandler<Object,Boolean> {
    private GameEngine engine=GameEngine.current;

    @Override
    protected Boolean execute(Object parameter) {
        return askEscape();
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
