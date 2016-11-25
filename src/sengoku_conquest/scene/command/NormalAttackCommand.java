package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.utilities.DamageCalcurator;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class NormalAttackCommand extends BattleCommandHandler {
    private GameEngine engine=GameEngine.current;
    private MainCharacter mainCharacter= GameApplication.current.getMainCharacter();
    @Override
    protected Boolean execute(EnemyCharacter enemy) {
        attackCharacter(mainCharacter,enemy);

        if(enemy.getLevel()==4&&enemy.getStatus().getCurrentHp()<enemy.getStatus().getCurrentHp()/2){
            //TODO : ボスキャラクター実装後に
        }else {
            attackCharacter(enemy,mainCharacter);
        }

        return true;
    }

    protected void attackCharacter(Character attacker,Character defender){
        engine.showMessage(attacker.getName()+"の攻撃!");

        final int damage = DamageCalcurator.calc(attacker.getStatus().getAtk(), defender.getStatus().getDef());

        engine.showMessage(damage+"のダメージ!");

        didAttacked(defender,damage);
    }
    
    private void didAttacked(Character character, int damage){
        character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
    }

    private void didSpecialAttack(){

    }
}