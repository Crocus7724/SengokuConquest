package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class SpecialAttackCommand extends NormalAttackCommand {
    private MainCharacter mainCharacter= GameApplication.current.getMainCharacter();

    @Override
    protected Boolean execute(EnemyCharacter enemy) {
        //TODO : 特殊攻撃実装後に実装
    }
}
