package sengoku_conquest.map;

import sengoku_conquest.item.HpItem;
import sengoku_conquest.item.Item;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class ItemArea extends Area {
    private Item item;
    private boolean isFind=false;
    public ItemArea(Item item,int areaNumber, String areaName, NextAreaInfo nextAreaInfo) {
        super(areaNumber, areaName, nextAreaInfo);
        this.item=item;
    }

    public Item getItem() {
        isFind=true;
        return item;
    }

    public boolean isFind() {
        return isFind;
    }
}
