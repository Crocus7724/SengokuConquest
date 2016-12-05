package sengoku_conquest.character;

import com.sun.tools.internal.jxc.ap.Const;
import sengoku_conquest.const_values.Consts;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class EnemyCharacter extends Character {
    public EnemyCharacter(String name, int level) {
        super(initStatus(level), name, level);
    }
//    private int pops = 0;

    public int doSpecialAtack() {
        return 0;
    }

    private static Status initStatus(int level){
        switch (level){
            case 1:
                return new Status(
                        Consts.LEVEL1_ENEMY_HP,
                        Consts.LEVEL1_ENEMY_EP,
                        Consts.LEVEL1_ENEMY_ATTACK,
                        Consts.LEVEL1_ENEMY_DEF);
            case 2:
                return new Status(
                        Consts.LEVEL2_ENEMY_HP,
                        Consts.LEVEL2_ENEMY_EP,
                        Consts.LEVEL2_ENEMY_ATTACK,
                        Consts.LEVEL2_ENEMY_DEF);
            case 3:
                return new Status(
                        Consts.LEVEL3_ENEMY_HP,
                        Consts.LEVEL3_ENEMY_EP,
                        Consts.LEVEL3_ENEMY_ATTACK,
                        Consts.LEVEL3_ENEMY_DEF);
            case 4:
                return new Status(
                        Consts.LEVEL4_ENEMY_HP,
                        Consts.LEVEL4_ENEMY_EP,
                        Consts.LEVEL4_ENEMY_ATTACK,
                        Consts.LEVEL4_ENEMY_DEF);
        }

        return null;
    }
}



