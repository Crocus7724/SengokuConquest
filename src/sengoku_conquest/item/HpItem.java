package sengoku_conquest.item;

import sengoku_conquest.character.Character;

/**
 * Created by C0114544 on 2016/11/18.
 */

public class HpItem implements Item {

    @Override
    public String getName() {

        return "握り飯";
    }

    public int recoveryHP = 50;

    @Override
    public void useItem(Character character) {
        int hp  = character.getStatus().getCurrentHp() + recoveryHP;

        if(hp > character.getStatus().getMaxHp()) {
            hp = character.getStatus().getMaxHp();
        }

        character.getStatus().setCurrentHp(hp);

        }
    }
}
