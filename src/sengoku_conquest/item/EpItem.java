package sengoku_conquest.item;

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
    public int useItem() {
        return 0;
    }
}
