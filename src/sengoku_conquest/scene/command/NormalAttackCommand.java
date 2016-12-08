package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.BossCharacter;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.utilities.DamageCalcurator;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class NormalAttackCommand extends BattleCommandHandler {
    protected GameEngine engine = GameEngine.current;
    protected MainCharacter mainCharacter = GameApplication.current.getMainCharacter();

    public NormalAttackCommand() {

    }

    @Override
    protected Boolean execute(EnemyCharacter enemy) {
        attackCharacter(mainCharacter, enemy);

        if (!checkCharacterHp(enemy)) return true;


        if (isEnemySpecialAttackConditions(enemy)) {
            doEnemySpecialAttackIfHalfHp(enemy);
        } else {
            attackCharacter(enemy, mainCharacter);
        }

        if (!checkCharacterHp(mainCharacter)) return true;

        return false;
    }

    @Override
    public String getCommandName() {
        return Strings.NORMAL_ATTACK_COMMAND_NAME;
    }

    protected void attackCharacter(Character attacker, Character defender) {
        engine.showFormattedMessage( Strings.ATTACK,attacker.getName());

        final int damage = DamageCalcurator.calc(attacker.getStatus().getAtk(), defender.getStatus().getDef());

        engine.showFormattedMessage(Strings.DAMAGE,defender.getName(),damage);

        didAttacked(defender, damage);
    }

    protected void doEnemySpecialAttackIfHalfHp(EnemyCharacter enemy) {
        final BossCharacter boss = (BossCharacter) enemy;
        if (!boss.getIsCharged()) {
            engine.showFormattedMessage(Strings.CHARGE_BOSS,boss.getName());
            boss.setCharged(true);
        } else {
            engine.showFormattedMessage(Strings.SPECIAL_ATTACK_BOSS,enemy.getName());
            final int damage = DamageCalcurator.calc((int) (enemy.getStatus().getAtk() * Consts.BOSS_SPECIAL_ATTACK),
                    mainCharacter.getStatus().getDef());
            engine.showFormattedMessage(Strings.DAMAGE,mainCharacter.getName(),damage);
            didAttacked(mainCharacter, damage);
            enemy.getStatus().setCurrentEp(enemy.getStatus().getCurrentEp() - 1);
        }
    }

    protected boolean isEnemySpecialAttackConditions(EnemyCharacter enemy) {
        return enemy.getLevel() == 4
                && enemy.getStatus().getCurrentEp() > 0
                && enemy.getStatus().getCurrentHp() <= Consts.BOSS_SPECIAL_ATTACK_CONDITION;
    }

    private void didAttacked(Character character, int damage) {
        character.getStatus().setCurrentHp(character.getStatus().getCurrentHp() - damage);
    }

    protected boolean checkCharacterHp(Character character) {
        return character.getStatus().getCurrentHp() > 0;
    }
}