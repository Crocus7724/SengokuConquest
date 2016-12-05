package sengoku_conquest.item;

import sengoku_conquest.character.Character;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;

/**
 * Created by C0114544 on 2016/11/18.
 */

public class EpItem implements Item{
    @Override
    public String getName() {
        return Strings.EP_ITEM_NAME;
    }

    public int recoveryEp = Consts.RECOVERY_EP_VALUE;

    @Override
    public void useItem(Character character) {
        int ep  = character.getStatus().getCurrentEp() + recoveryEp;
        if(ep > character.getStatus().getMaxEp()) {
            ep = character.getStatus().getMaxEp();
        }
        character.getStatus().setCurrentEp(ep);

    }
}
