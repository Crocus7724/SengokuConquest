package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.item.EpItem;
import sengoku_conquest.item.HpItem;
import sengoku_conquest.item.Item;
import com.sun.org.apache.xpath.internal.operations.String;

import java.util.List;

import sengoku_conquest.GameEngine;
import sengoku_conquest.map.Area;

/**
 * Created by C0114544 on 2016/11/25.
 */

public class ItemCommand extends AreaCommandHandler {

    @Override
    protected Boolean execute(Area parameter) {
        List<Item> itemList = GameApplication.current.getMainCharacter().getItems();
        int hpItemCount = 0;
        int epItemCount = 0;

        for (Item item:itemList){
            if(item instanceof HpItem) {
                hpItemCount++;
            }
            if(item instanceof EpItem){
                epItemCount++;
            }
            else{
                //engine.showMessage("どこかでバグが起きてるYO/n");
            }
            }

        boolean hasHpItem=false;
        if(hpItemCount>0){
            //TODO : HPアイテム表示フラグ
            hasHpItem=true;
        }

        if(epItemCount>0){
            // TODO : EPアイテム表示フラグ
        }
return null;
        }

    }
}