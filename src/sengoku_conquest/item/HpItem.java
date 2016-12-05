package sengoku_conquest.item;

import sengoku_conquest.character.Character;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;

/**
 * Created by C0114544 on 2016/11/18.
 */

public class HpItem implements Item {

    @Override
    public String getName() {

        return Strings.HP_ITEM_NAME;
    }

    public int recoveryHP = Consts.RECOVERY_HP_VALUE;

    @Override
    public void useItem(Character character) {
        int hp  = character.getStatus().getCurrentHp() + recoveryHP;

        if(hp > character.getStatus().getMaxHp()) {
            hp = character.getStatus().getMaxHp();
        }

        character.getStatus().setCurrentHp(hp);

        }
    }


