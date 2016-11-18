package sengoku_conquest.item;

import sengoku_conquest.character.Character;

/**
 * Created by C0114544 on 2016/11/18.
 */

public class EpItem implements Item{
    @Override
    public String getName() {
        return "いにしえの秘薬";
    }

    public int recoveryEp = 3;

    @Override
    public void useItem(Character character) {
        int ep  = character.getStatus().getCurrentEp() + recoveryEp;
        if(ep > character.getStatus().getMaxEp()) {
            ep = character.getStatus().getMaxEp();
        }
        character.getStatus().setCurrentEp(ep);

    }
}



}
