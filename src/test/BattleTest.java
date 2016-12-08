package test;

import sengoku_conquest.GameApplication;
import sengoku_conquest.character.*;
import sengoku_conquest.utilities.DamageCalcurator;

import java.util.List;

/**
 * Created by Yamamoto on 2016/12/02.
 */
public class BattleTest {

    private int[] expList = {0, 1, 4, 7, 10, 15};

    public void testNormalAttack() {
        int tryCount = 1000000;

        System.out.println("通常攻撃時テスト\n\n");
        for (int exp = 0; exp < expList.length; exp++) {
            System.out.println("-----------------------------");
            System.out.println("MainCharacter　レベル:" + (exp + 1));
            System.out.println("-----------------------------");
            for (int i = 1; i < 5; i++) {
                System.out.println("=====================");
                System.out.println("敵レベル" + i + "テスト");
                System.out.println("=====================");
                for (JobType type : JobType.values()) {
                    System.out.println(type.name() + "テスト");
                    int win = 0;
                    for (int j = 0; j < tryCount; j++) {
                        MainCharacter mainCharacter = new MainCharacter(new Job(type));
                        mainCharacter.setExp(exp);
                        EnemyCharacter enemyCharacter = new EnemyCharacter("レベル1", i);
                        final boolean isWin = attackNormalAttack(mainCharacter.getStatus(), enemyCharacter.getStatus());
                        if (isWin) {
                            win++;
                        }
                    }
                    System.out.println("\t勝率 : " + win / (double) tryCount * 100 + "%");
                }
            }
        }
    }

    private boolean attackNormalAttack(Status mainStatus, Status enemyStatus) {
        attack(mainStatus, enemyStatus);

        if (!hasHp(enemyStatus)) return true;

        attack(enemyStatus, mainStatus);

        if (!hasHp(mainStatus)) return false;

        return attackNormalAttack(mainStatus, enemyStatus);
    }

    private void attack(Status attacker, Status defender) {
        int damage = DamageCalcurator.calc(attacker.getAtk(), defender.getDef());

        defender.setCurrentHp(defender.getCurrentHp() - damage);
    }

    private boolean hasHp(Status status) {
        return status.getCurrentHp() > 0;
    }
}
