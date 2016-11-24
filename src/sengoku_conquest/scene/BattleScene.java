package sengoku_conquest.scene;

import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.scene.command.CommandHandler;
import sengoku_conquest.scene.command.EscapeCommand;
import sengoku_conquest.scene.command.NormalAttackCommand;
import sengoku_conquest.scene.command.SpecialAttackCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class BattleScene extends Scene {
    private final EnemyCharacter enemy;
    private List<CommandHandler> commandList;

    public BattleScene(EnemyCharacter enemy){
        commandList=new ArrayList<>();
        commandList.add(new NormalAttackCommand());
        commandList.add(new SpecialAttackCommand());
        commandList.add(new EscapeCommand());
        this.enemy=enemy;
    }

    @Override
    void start() {
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }
}
