package sengoku_conquest.item;

import sengoku_conquest.character.Character;

/**
 * Created by C0114544 on 2016/11/18.
 */

public interface Item {
    String getName();

    void useItem(Character character);
}
