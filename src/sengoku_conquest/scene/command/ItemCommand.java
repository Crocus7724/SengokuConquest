package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.character.Status;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.item.EpItem;
import sengoku_conquest.item.HpItem;
import sengoku_conquest.item.Item;

import java.util.List;
import java.util.Optional;

import sengoku_conquest.GameEngine;
import sengoku_conquest.map.Area;

/**
 * Created by C0114544 on 2016/11/25.
 */

public class ItemCommand extends AreaCommandHandler {

    private GameEngine engine = GameEngine.current;

    @Override
    protected Boolean execute(Area parameter) {
        List<Item> itemList = GameApplication.current.getMainCharacter().getItems();
        int hpItemCount = 0;
        int epItemCount = 0;
        int n = 0;

        for (Item item : itemList) {
            if (item instanceof HpItem) {
                hpItemCount++;
            }
            if (item instanceof EpItem) {
                epItemCount++;
            }
        }

        engine.showMessage(Strings.SELECTED_USE_ITEM);

        boolean hasHpItem = false;
        if (hpItemCount > 0) {
            hasHpItem = true;
            n++;
            engine.showMessage(n + " : "+ Strings.HP_ITEM_NAME+":" + hpItemCount + Strings.ITEM_COUNT);
        }

        boolean hasEpItem = false;
        if (epItemCount > 0) {
            hasEpItem = true;
            n++;
            engine.showMessage(n + " : "+Strings.EP_ITEM_NAME+":" + epItemCount + Strings.ITEM_COUNT);
        }

        n++;
        engine.showMessage(n+" : "+Strings.NOT_USE);
        int input = GameEngine.current.readNumber(n);

        if (input == -1) {
            engine.showMessage(Strings.INVALID_INPUT);
            return execute(parameter);
        }

        if (input == n) {
            return false;
        }

        if (hasHpItem == false) {
            if (input == 1) {
                input = 2;
            }
        }

        final Status status = GameApplication.current.getMainCharacter().getStatus();

        switch (input) {
            case 1:
                if(status.getCurrentHp()==status.getMaxHp()){
                    engine.showMessage(Strings.FULL_HP);
                    return true;
                }
                Optional<Item> hpItem = itemList.stream().filter(x -> x instanceof HpItem).findFirst();
                if (hpItem.isPresent()) {
                    useItem(itemList.indexOf(hpItem.get()));
                    engine.showMessage(Strings.RECOVERY_HP);
                    engine.showMessage(Strings.HP+" : " + GameApplication.current.getMainCharacter().getStatus().getCurrentHp());
                    return true;
                }
            case 2:
                if(status.getCurrentEp()==status.getMaxEp()){
                    engine.showMessage(Strings.FULL_EP);
                    return false;
                }
                Optional<Item> epItem = itemList.stream().filter(x -> x instanceof EpItem).findFirst();
                if (epItem.isPresent()) {
                    useItem(itemList.indexOf(epItem.get()));
                    engine.showMessage(Strings.RECOVERY_EP);
                    engine.showMessage(Strings.EP+" : " + GameApplication.current.getMainCharacter().getStatus().getCurrentEp());
                    return true;
                }
        }

        return null;
    }

    @Override
    public String getCommandName() {
        return Strings.ITEM_COMMAND_NAME;
    }

    private void useItem(int index) {
        List<Item> itemList = GameApplication.current.getMainCharacter().getItems();
        itemList.get(index).useItem(GameApplication.current.getMainCharacter());
        GameApplication.current.getMainCharacter().getItems().remove(index);
    }
}
