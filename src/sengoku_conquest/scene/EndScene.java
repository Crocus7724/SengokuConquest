package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.const_values.Strings;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class EndScene extends Scene {
    private GameEngine engine;

    public EndScene() {
        this.engine = new GameEngine();
    }

    @Override
    void start() {
        if (GameApplication.current.getTurn() <= 0) {
            engine.showMessage(Strings.GAME_OVER);
            engine.showMessage(Strings.GAME_OVER_NOTING_TURN);
            continueCommand(false);
        } else if (GameApplication.current.getMainCharacter().getStatus().getCurrentHp() <= 0) {
            engine.showMessage(Strings.GAME_OVER);
            engine.showMessage(Strings.GAME_OVER_BATTLE_);
            continueCommand(false);
        } else {
            engine.showMessage(Strings.GAME_CLEAR);
            engine.showMessage(Strings.GAME_OVER_CLEAR);
            continueCommand(true);
        }

        engine.showMessage(Strings.STAFF_ROLL);
    }

    private void continueCommand(boolean isClear) {
        engine.showMessage("================================================");
        engine.showMessage("コンティニューしますか？");
        engine.showMessage("1:はい");
        engine.showMessage("2:いいえ");

        int contenueNum = engine.readNumber(2);
        if (contenueNum == 1) {
            if (!isClear){
                engine.showMessage(Strings.GAME_CONTINUE);
            }
            GameApplication.current.gameStart();

        } else if(contenueNum == 2) {
            engine.showMessage("ゲームを終了します");
            System.exit(1);
        } else {
            engine.showMessage(Strings.INVALID_INPUT);
            continueCommand(isClear);
        }
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }
}
