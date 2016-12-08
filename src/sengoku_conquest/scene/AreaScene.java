package sengoku_conquest.scene;


import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.item.Item;
import sengoku_conquest.map.Area;
import sengoku_conquest.map.BossArea;
import sengoku_conquest.map.EnemyArea;
import sengoku_conquest.map.ItemArea;
import sengoku_conquest.scene.command.AreaCommandHandler;
import sengoku_conquest.scene.command.ItemCommand;
import sengoku_conquest.scene.command.MoveCommand;
import sengoku_conquest.scene.command.RestCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class AreaScene extends Scene {
    private Area area;
    private GameEngine engine;
    private MainCharacter character = GameApplication.current.getMainCharacter();
    private List<AreaCommandHandler> commandList = new ArrayList<>();
    private AreaCommandHandler itemCommand = new ItemCommand();

    public AreaScene(Area area) {
        this.area = area;
        this.engine = new GameEngine();

        commandList.add(new MoveCommand());
        commandList.add(new RestCommand());
        commandList.add(new AreaCommandHandler() {
            @Override
            protected Boolean execute(Area parameter) {
                GameEngine.current.showMainCharacterStatus();
                return false;
            }

            @Override
            public String getCommandName() {
                return Strings.SHOW_STATUS_COMMAND_NAME;
            }
        });
    }

    @Override
    void start() {
        GameApplication.current.setCurrentArea(area);
        area.setReached(true);
        if (area instanceof ItemArea) {
            getItemFromArea((ItemArea) area);
        } else if (area instanceof BossArea) {
            GameApplication.current.nextScene(new BossScene((BossArea) area));
        } else if (area instanceof EnemyArea) {
            final EnemyArea enemyArea = (EnemyArea) this.area;

            if (enemyArea.getEnemy().getStatus().getCurrentHp() > 0) {
                GameApplication.current.nextScene(new BattleScene(enemyArea.getEnemy()));
            }

        }

        start(true);
    }

    private void start(boolean isInitial){
        GameEngine.current.showReachedMap();
        if (isInitial) GameApplication.current.decreaseTurn();
        GameEngine.current.showFormattedMessage(Strings.CURRENT_POSITION, area.getAreaNum());
        GameEngine.current.showFormattedMessage(Strings.CURRENT_TURN,GameApplication.current.getTurn());

        selectCommand();
        start(false);
    }

    @Override
    void end() {

    }

    @Override
    void restart() {
        if (GameApplication.current.getIsEscaped()) {
            GameApplication.current.setIsEscaped(false);
            GameApplication.current.previousScene();
            return;
        }else if(area.getAreaNum()==14){
            GameApplication.current.increaseTurn(1);
            GameApplication.current.previousScene();
            return;
        }

        start();
    }

    private void selectCommand() {
        engine.showMessage(Strings.SELECT_COMMAND);
        int i=0;

        for (; i < commandList.size(); i++) {
            engine.showCommandMessage(i + 1 ,commandList.get(i).getCommandName());
        }

        boolean hasItem = false;

        if (character.getItems().size() > 0) {
            engine.showCommandMessage(i + 1  , itemCommand.getCommandName());
            hasItem = true;
        }

        final int input = engine.readNumber(commandList.size() + (hasItem ? 1 : 0));

        if (input == -1) {
            engine.showMessage(Strings.INVALID_INPUT);
            selectCommand();
            return;
        }
        if (input == i + 1) {
            itemCommand.doExecute(area);
        } else {
            final Boolean result = commandList.get(input - 1).doExecute(area);
            if(!result){
                selectCommand();
            }
        }
    }

    private void getItemFromArea(ItemArea area) {
        if (area.isFind()) return;
        final Item item = area.getItem();

        engine.showFormattedMessage(Strings.FIND_ITEM,item.getName() );

        GameApplication.current.getMainCharacter().getItems().add(item);
    }
}





