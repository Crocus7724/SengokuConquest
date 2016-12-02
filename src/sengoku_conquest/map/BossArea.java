package sengoku_conquest.map;

import sengoku_conquest.character.BossCharacter;
import sengoku_conquest.character.Character;
import sengoku_conquest.character.EnemyCharacter;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class BossArea extends EnemyArea {
    public BossArea(int areaNum, String areaName, NextAreaInfo nextAreaInfo) {
        super(new BossCharacter(),areaNum, areaName, nextAreaInfo);
    }

}
