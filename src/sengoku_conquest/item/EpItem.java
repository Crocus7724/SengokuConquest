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

    @Override
    public void useItem(Character character) {
        character.getStatus();

    }

    public int recoveryEp = 3;

}
