package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.*;
import sengoku_conquest.character.Character;
import sengoku_conquest.const_values.Strings;

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
            GameEngine.current.showMessage(Strings.NOT_HAVE_EP);
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

        if(!checkCharacterHp(mainCharacter)&&mainCharacter.getJob().getType()!=JobType.NINJA){
            return true;
        }

        specialAttack.didAttacked(enemy);

        if(!checkCharacterHp(enemy))return true;

        return false;
    }

    @Override
    public String getCommandName() {
        return mainCharacter.getJob().getSpecialAttack().getName();
    }

    private void doSpecialAttack(EnemyCharacter character){
        engine.showMessage(specialAttack.getName()+Strings.USE_SPECIAL_ATTACK);

        specialAttack.attack(character);
    }
}
