package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.item.EpItem;
import sengoku_conquest.scene.command.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class BattleScene extends Scene {
    private final GameEngine engine = GameEngine.current;
    private final MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
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
        engine.showFormattedMessage(Strings.APPEAR_ENEMY, enemy.getName(), enemy.getLevel());

        if (!run()) {
            GameApplication.current.nextScene(new EndScene());
        } else {
            if (enemy.getLevel() == Consts.FIND_ITEM_CONDITION) {
                final EpItem epItem = new EpItem();
                GameEngine.current.showFormattedMessage(Strings.FIND_ITEM, epItem.getName());
                mainCharacter.getItems().add(epItem);
            }

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
                engine.showMessage(Strings.ESCAPED);
                GameApplication.current.setIsEscaped(true);
                GameApplication.current.decreaseTurn();
                GameApplication.current.previousScene();
                return true;
            } else {
                return run();
            }
        }

        if (command.doExecute(enemy)) {
            if (GameApplication.current.getMainCharacter().getStatus().getCurrentHp() <= 0) {
                return false;
            } else if (enemy.getStatus().getCurrentHp() <= 0) {
                GameEngine.current.showFormattedMessage(Strings.KILL_ENEMY, enemy.getName());
                addExp(enemy.getLevel());
                GameApplication.current.increaseKilledCount();
                int killcount = GameApplication.current.getKilledCount();
                //GameEngine.current.showMessage(killcount+"");
                if (killcount % Consts.RECOVERY_TURN_CONDITION == 0) {
                    GameApplication.current.increaseTurn(Consts.RECOVERY_TURN);
                    GameEngine.current.showFormattedMessage(Strings.RECOVERY_TURN, Consts.RECOVERY_TURN);
                }
                return true;
            }
        }
        return run();
    }

    private BattleCommandHandler askCommand() {
        GameEngine.current.showMainCharacterStatus();
        GameEngine.current.showBar(Strings.ENEMY_HP, enemy.getStatus().getMaxHp(), enemy.getStatus().getCurrentHp());
        engine.showMessage(Strings.SELECT_COMMAND);

        for (int i = 0; i < commandList.size(); i++) {
            GameEngine.current.showCommandMessage(i + 1, commandList.get(i).getCommandName());
        }

        final int input = engine.readNumber(commandList.size());

        if (input != -1) {
            if (input <= commandList.size()) {
                return commandList.get(input - 1);
            }
        }

        engine.showMessage(Strings.INVALID_INPUT);

        return askCommand();
    }

    private void addExp(int exp) {
        GameEngine.current.showFormattedMessage(Strings.GET_EXP, mainCharacter.getName(), exp);
        final int level = mainCharacter.getLevel();
        mainCharacter.setExp(enemy.getLevel());

        if (mainCharacter.getLevel() != level) {
            GameEngine.current.showMessage(Strings.LEVEL_UP);
            engine.showMainCharacterStatus();
        }
    }
}
