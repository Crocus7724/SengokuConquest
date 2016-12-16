package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.Job;
import sengoku_conquest.character.JobType;
import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class StartScene extends Scene {

    @Override
    void start() {

        GameEngine.current.showMessage(Strings.TITLE);
        GameEngine gm = GameEngine.current;
        gm.showMessage(Strings.TITLE);

        startCommand(gm);

        selectJob(gm);

        GameApplication.current.nextScene(new AreaScene(GameApplication.current.getMap().get(Consts.START_POSITION)));
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }

    private void startCommand(GameEngine gm) {
        gm.showCommandMessage(1, Strings.SHOW_STORY);
        gm.showCommandMessage(2, Strings.SHOW_RULE);
        gm.showCommandMessage(3, Strings.GAME_START);

        int input = GameEngine.current.readNumber(3);

        if (input == -1) {
            gm.showMessage(Strings.INVALID_INPUT);
            startCommand(gm);
            return;
        }
        if (input == 1) {
            gm.showMessage(Strings.STORY);
            startCommand(gm);
            return;
        }
        if (input == 2) {
            gm.showMessage(Strings.RULE);
            startCommand(gm);
            return;
        }
    }

    private void selectJob(GameEngine gm) {
        gm.showMessage(Strings.SELECT_JOB);
        JobType[] values = JobType.values();
        String[] chara={Strings.JOB_SAMURAI, Strings.JOB_NINJA, Strings.JOB_ASHIGARU, Strings.JOB_KOMUSOU};

        int maxWord = MaxWordCount();

        for (int i = 0; i < values.length; i++) {
            JobType type = values[i];
            gm.showCommandMessage(i + 1, getIndentation(type.name(),maxWord) + " : " + chara[i]);
        }

        int num = gm.readNumber(values.length);

        if (num == -1) {
            gm.showMessage(Strings.INVALID_INPUT);
            selectJob(gm);
            return;
        }

        Job job = new Job(values[num - 1]);
        GameApplication.current.setMainCharacter(new MainCharacter(job));
    }

    private int MaxWordCount(){
        JobType[] values = JobType.values();
        int maxWord = 0;

        for (int i = 0; i < values.length; i++) {
            JobType type = values[i];
            if(maxWord < type.name().length()){
                maxWord = type.name().length();
            }
        }
        return maxWord;
    }

    private String getIndentation(String title, int maxWord) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < maxWord-title.length() ; i++) {
            s.append(" ");
        }
        title += s;
        return title;
    }
}
