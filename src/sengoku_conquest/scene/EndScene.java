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
        } else if (GameApplication.current.getMainCharacter().getStatus().getCurrentHp() <= 0) {
            engine.showMessage(Strings.GAME_OVER);
            engine.showMessage(Strings.GAME_OVER_BATTLE_);
        } else {
            engine.showMessage(Strings.GAME_CLEAR);
            engine.showMessage(Strings.GAME_OVER_CLEAR);
        }

        engine.showMessage(Strings.STAFF_ROLL);
        Continue();
    }

    private void Continue() {
        engine.showMessage("================================================");
        engine.showMessage("コンティニューしますか？");
        engine.showMessage("1:はい");
        engine.showMessage("2:いいえ");

        int contenueNum = engine.readNumber(2);
        if (contenueNum == 1) {
            GameApplication.current.gameStart();

        } else if(contenueNum == 2) {
            engine.showMessage("ゲームを終了します");
            System.exit(1);
        } else {
            engine.showMessage(Strings.INVALID_INPUT);
            Continue();
        }
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }
}
