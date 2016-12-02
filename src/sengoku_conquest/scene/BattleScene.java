package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.scene.command.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class BattleScene extends Scene {
    private final GameEngine engine = GameEngine.current;
    private final MainCharacter mainCharacter=GameApplication.current.getMainCharacter();
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
        engine.showMessage(enemy.getName()+" Level"+enemy.getLevel() + "が現れた!!");

        if (!run()) {
            GameApplication.current.nextScene(new EndScene());
        } else {
            GameApplication.current.increaseKilledCount();
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
                GameApplication.current.setIsEscaped(true);
                GameApplication.current.decreaseTurn();
                GameApplication.current.previousScene();
                return true;
            }
        }

        if(command.doExecute(enemy)) {
            if (GameApplication.current.getMainCharacter().getStatus().getCurrentHp() <= 0) {
                return false;
            } else if (enemy.getStatus().getCurrentHp() <= 0) {
                GameEngine.current.showMessage(enemy.getName() + "を倒した!!");
                addExp(enemy.getLevel());
                return true;
            }
        }
        return run();
    }

    private BattleCommandHandler askCommand() {
        GameEngine.current.showMainCharacterStatus();
        GameEngine.current.showBar("敵体力 : ", enemy.getStatus().getMaxHp(), enemy.getStatus().getCurrentHp());
        engine.showMessage("コマンドを選択して下さい");

        for (int i=0;i<commandList.size();i++){
            GameEngine.current.showMessage(i+1+" : "+commandList.get(i).getCommandName());
        }

        final int input = engine.readNumber(commandList.size());

        if(input!=-1){
            if (input <= commandList.size()) {
                return commandList.get(input - 1);
            }
        }

        engine.showMessage("入力に誤りがあります");

        return askCommand();
    }

    private void addExp(int exp){
        GameEngine.current.showMessage("経験値を"+exp+"手に入れた!");
        final int level = mainCharacter.getLevel();
        mainCharacter.setExp(enemy.getLevel());

        if(mainCharacter.getLevel()!=level){
            GameEngine.current.showMessage("レベルが上った!!");
            engine.showMainCharacterStatus();
        }
    }
}
