package sengoku_conquest.scene.command;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.map.Area;

/**
 * Created by C0114105 on 2016/11/25.
 */
public class RestCommand extends AreaCommandHandler {
    private GameEngine engine = GameEngine.current;
    private MainCharacter character = GameApplication.current.getMainCharacter();

    public int recoverHp;
    private boolean result;

    @Override
    protected Boolean execute(Area parameter) {
        return askRest();
    }

    @Override
    public String getCommandName() {
        return Strings.REST_COMMAND_NAME;
    }


    private boolean askRest(){
        engine.showMessage(Strings.QUESTION_REST);
        engine.showCommandMessage(1,Strings.YES);
        engine.showCommandMessage(2,Strings.NO);
        final int input = engine.readNumber(2);

        if(input==-1){
            engine.showMessage(Strings.INVALID_INPUT);
            return askRest();
        }

        if(input==1){
            this.recoverHp = 30;
            int HP = character.getStatus().getCurrentHp()+recoverHp;

            if(HP>character.getStatus().getMaxHp()){
                HP = character.getStatus().getMaxHp();
            }
            character.getStatus().setCurrentHp(HP);
            GameApplication.current.decreaseTurn();
            result = true;
        }

        if(input==2){
            result = false;
        }

        return result;
    }



}
