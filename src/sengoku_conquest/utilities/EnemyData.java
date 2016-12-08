package sengoku_conquest.utilities;

import sengoku_conquest.character.EnemyCharacter;

/**
 * Created by Yamamoto on 2016/11/24.
 */
public class EnemyData {
    public final int popMin;
    public final int popMax;
    public final EnemyCharacter enemy;

    public EnemyData(EnemyCharacter enemy, int popMin, int popMax) {
        this.popMin = popMin;
        this.popMax = popMax;
        this.enemy = enemy;
    }
}
