package sengoku_conquest.item;

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
    public int useItem() {
        return 0;
    }
}
