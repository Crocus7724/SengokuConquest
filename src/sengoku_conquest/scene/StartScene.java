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
        GameEngine gm = GameEngine.current;
        gm.showCommandMessage(1,Strings.SHOW_STORY);
        gm.showCommandMessage(2,Strings.SHOW_RULE);
        gm.showCommandMessage(3,Strings.GAME_START);

        int input = GameEngine.current.readNumber(3);

        if (input == -1) {
            gm.showMessage(Strings.INVALID_INPUT);
            start();
            return;
        }

        // ストーリー表示
        if (input == 1) {
            gm.showMessage(Strings.STORY);
            start();
            return;
        }

        // ルール表示
        if (input == 2) {
            gm.showMessage(Strings.RULE);
            start();
            return;
        }
        gm.showMessage(Strings.SELECT_JOB);
        JobType[] values = JobType.values();
        for (int i = 0; i < values.length; i++) {
            JobType type = values[i];
            gm.showCommandMessage(i + 1 ,type.name());
        }

        int num = gm.readNumber(values.length);

        if (num == -1) {
            gm.showMessage(Strings.INVALID_INPUT);
            start();
            return;
        }

        Job job = new Job(values[num - 1]);

        GameApplication.current.setMainCharacter(new MainCharacter(job));

        // エリアシーンへ
        GameApplication.current.nextScene(new AreaScene(GameApplication.current.getMap().get(Consts.START_POSITION)));

    }

    // 選択チェック
    private static int check(GameEngine gm, int max) {
        String str = gm.readLineFromUserInput();

        if (str == null || !str.matches("[0-9]")) {
            gm.showMessage(Strings.SELECT_COMMAND);
            return check(gm, max);
        }
        int num = Integer.parseInt(str);
        if (num < 1 || num >= max) {
            gm.showMessage("選択肢の数字を入力してください");
            return check(gm, max);
        }
        return num;
    }


    @Override
    void end() {

    }

    @Override
    void restart() {

    }

}
