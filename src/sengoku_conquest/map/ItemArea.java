package sengoku_conquest.map;

import sengoku_conquest.item.Item;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class ItemArea extends Area {
    private Item item;
    public ItemArea(int areanum, String areaname, NextAreaInfo nextAreaInfo) {
        super(areanum, areaname, nextAreaInfo);
    }

    public Item getItem() {
        return item;
    }
}
