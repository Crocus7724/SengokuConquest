package sengoku_conquest.map;

import sengoku_conquest.character.EnemyCharacter;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class EnemyArea extends Area {
    private EnemyCharacter enemy;

    public EnemyArea(EnemyCharacter enemy, int areanum, String areaname, NextAreaInfo nextAreaInfo) {
        super(areanum, areaname, nextAreaInfo);
        this.enemy = enemy;
    }

    public EnemyCharacter getEnemy() {
        return enemy;
    }
}
