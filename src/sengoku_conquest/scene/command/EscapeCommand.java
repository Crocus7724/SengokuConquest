package sengoku_conquest.scene.command;

import sengoku_conquest.GameEngine;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.const_values.Strings;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class EscapeCommand extends BattleCommandHandler {
    private GameEngine engine = GameEngine.current;

    @Override
    protected Boolean execute(EnemyCharacter parameter) {
        return askEscape();
    }

    @Override
    public String getCommandName() {
        return Strings.ESCAPE_COMMAND_NAME;
    }

    private boolean askEscape() {
        engine.showMessage(Strings.REALLY_ESCAPE);

        engine.showCommandMessage(1, Strings.YES);
        engine.showCommandMessage(2, Strings.NO);

        final int input = engine.readNumber(2);

        if (input == -1) {
            engine.showMessage(Strings.INVALID_INPUT);
            return askEscape();
        }

        return input == 1;
    }
}
