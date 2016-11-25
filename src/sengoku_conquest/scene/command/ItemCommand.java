package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
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
            } else {
                engine.showMessage("どこかでバグが起きてるYO/n");
            }
        }

        engine.showMessage("使用するアイテムを選択してください。");

        boolean hasHpItem = false;
        if (hpItemCount > 0) {
            hasHpItem = true;
            n++;
            engine.showMessage(n + " : 握り飯:" + hpItemCount + "個");
        }

        boolean hasEpItem = false;
        if (epItemCount > 0) {
            hasEpItem = true;
            n++;
            engine.showMessage(n + " : いにしえの秘薬:" + epItemCount + "個");
        } else {
            engine.showMessage("どこかでバグが起きてるYO");
        }

        n++;
        engine.showMessage(n+" : 使用しない");
        int input = GameEngine.current.readNumber(n);

        if (input == -1) {
            engine.showMessage("正しい数字を入力してください。");
            return execute(parameter);
        }

        if (input == n) {
            return false;
        }

        if (hasHpItem == false) {
            if (input == 1) {
                for (int i = 0; i < itemList.size(); i++) {
                    if (itemList.get(i) instanceof EpItem) {
                        useItem(i);
                        break;
                    }
                }
                return true;
            }
        } else {
            switch (input) {
                case 1:
                    Optional<Item> hpItem = itemList.stream().filter(x -> x instanceof HpItem).findFirst();
                    if (hpItem.isPresent()) {
                        useItem(itemList.indexOf(hpItem.get()));
                        engine.showMessage("HPが回復しました。");
                        engine.showMessage("HP:" + GameApplication.current.getMainCharacter().getStatus().getCurrentHp());
                        return true;
                    }
                case 2:
                    Optional<Item> epItem = itemList.stream().filter(x -> x instanceof EpItem).findFirst();
                    if (epItem.isPresent()) {
                        useItem(itemList.indexOf(epItem.get()));
                        engine.showMessage("EP:" + GameApplication.current.getMainCharacter().getStatus().getCurrentEp());
                        return true;
                    }

            }

        }
        return null;
    }

    @Override
    public String getCommandName() {
        return "アイテム使用";
    }

    private void useItem(int index) {
        List<Item> itemList = GameApplication.current.getMainCharacter().getItems();
        itemList.get(index).useItem(GameApplication.current.getMainCharacter());
        GameApplication.current.getMainCharacter().getItems().remove(index);
    }
}
