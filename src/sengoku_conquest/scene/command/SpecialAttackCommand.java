package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.character.SpecialAttack;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class SpecialAttackCommand extends NormalAttackCommand {
    private MainCharacter mainCharacter= GameApplication.current.getMainCharacter();
    private SpecialAttack specialAttack;

    @Override
    protected Boolean execute(EnemyCharacter enemy) {
        final int currentEp = mainCharacter.getStatus().getCurrentEp();
        if(currentEp==0){
            GameEngine.current.showMessage("EPが足りません");
            return false;
        }

        mainCharacter.getStatus().setCurrentEp(currentEp - 1);
        specialAttack=mainCharacter.getJob().getSpecialAttack();
        doSpecialAttack(enemy);

        if(!checkCharacterHp(enemy))return true;

        if(isEnemySpecialAttackConditions(enemy)){
            doEnemySpecialAttackIfHalfHp(enemy);
        }else {
            attackCharacter(enemy,mainCharacter);
        }

        specialAttack.didAttacked(enemy);

        if(!checkCharacterHp(mainCharacter))return true;

        return false;
    }

    @Override
    public String getCommandName() {
        return "特殊攻撃";
    }

    private void doSpecialAttack(EnemyCharacter character){
        engine.showMessage(specialAttack.getName()+"を使った!!");

        specialAttack.attack(character);
    }
}
