package sengoku_conquest.scene;

import com.sun.org.apache.xpath.internal.operations.String;

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

        System.exit(1);
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }
}
