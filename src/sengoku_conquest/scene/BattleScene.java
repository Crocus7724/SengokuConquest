package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.scene.command.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class BattleScene extends Scene {
    private final GameEngine engine = GameEngine.current;
    private final EnemyCharacter enemy;
    private List<BattleCommandHandler> commandList;

    public BattleScene(EnemyCharacter enemy) {
        commandList = new ArrayList<>();
        commandList.add(new NormalAttackCommand());
        commandList.add(new SpecialAttackCommand());
        commandList.add(new EscapeCommand());
        this.enemy = enemy;
    }

    @Override
    void start() {
        engine.showMessage(enemy.getName() + "が現れた!!");

        if (!run()) {
            GameApplication.current.nextScene(new EndScene());
        } else {
            GameApplication.current.previousScene();
        }
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }

    private boolean run() {
        final BattleCommandHandler command = askCommand();

        if (command instanceof EscapeCommand) {
            if (command.doExecute(enemy)) {
                engine.showMessage("逃走した!!");
                GameApplication.current.decreaseTurn();
                GameApplication.current.previousScene();
            }
        }

        command.doExecute(enemy);

        if (GameApplication.current.getMainCharacter().getStatus().getCurrentHp() <= 0) {
            return false;
        } else if (enemy.getStatus().getCurrentHp() <= 0) {
            return true;
        }

        return run();
    }

    private BattleCommandHandler askCommand() {
        engine.showMessage("コマンドを選択して下さい");

        engine.showMessage("1 : 通常攻撃");
        engine.showMessage("2 : 特殊攻撃");
        engine.showMessage("3 : 逃げる");

        final int input = engine.readNumber(commandList.size());

        if (input <= commandList.size()) {
            return commandList.get(input - 1);
        }

        engine.showMessage("入力に誤りがあります");

        return askCommand();
    }
}
