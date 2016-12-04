package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.BossCharacter;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.const_values.Consts;
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
        return "通常攻撃";
    }

    protected void attackCharacter(Character attacker, Character defender) {
        engine.showMessage(attacker.getName() + "の攻撃!");

        final int damage = DamageCalcurator.calc(attacker.getStatus().getAtk(), defender.getStatus().getDef());

        engine.showMessage(damage + "のダメージ!");

        didAttacked(defender, damage);
    }

    protected void doEnemySpecialAttackIfHalfHp(EnemyCharacter enemy) {
        final BossCharacter boss = (BossCharacter) enemy;
        if (!boss.getIsCharged()) {
            engine.showMessage(boss.getName() + "は溜めている・・・");
            boss.setCharged(true);
        } else {
            engine.showMessage(enemy.getName() + "は全ての力を解き放った!!");
            final int damage = DamageCalcurator.calc((int) (enemy.getStatus().getAtk() * Consts.BOSS_SPECIAL_ATTACK),
                    mainCharacter.getStatus().getDef());
            engine.showMessage(mainCharacter.getName() + "は" + damage + "のダメージ!");
            didAttacked(mainCharacter, damage);
        }
    }

    protected boolean isEnemySpecialAttackConditions(EnemyCharacter enemy) {
        return enemy.getLevel() == 4
                && enemy.getStatus().getCurrentEp() > 0
                && enemy.getStatus().getCurrentHp() <= 70;
    }

    private void didAttacked(Character character, int damage) {
        character.getStatus().setCurrentHp(character.getStatus().getCurrentHp() - damage);
    }

    protected boolean checkCharacterHp(Character character) {
        return character.getStatus().getCurrentHp() > 0;
    }
}