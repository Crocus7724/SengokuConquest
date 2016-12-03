package sengoku_conquest.scene;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.character.Job;
import sengoku_conquest.character.JobType;
import sengoku_conquest.character.MainCharacter;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class StartScene extends Scene {

    @Override
    void start() {
        GameEngine gm = GameEngine.current;
        gm.showMessage("1：物語を読む");
        gm.showMessage("2：ルール表示");
        gm.showMessage("3：ゲームスタート");

        int input = GameEngine.current.readNumber(3);

        if (input == -1) {
            gm.showMessage("値が不正です。");
            start();
            return;
        }

        // ストーリー表示
        if (input == 1) {
            gm.showMessage("");
        }

        // ルール表示
        if (input == 2) {
            gm.showMessage("");
        }
        gm.showMessage("職を選択してください");
        JobType[] values = JobType.values();
        for (int i = 0; i < values.length; i++) {
            JobType type = values[i];
            gm.showMessage(i + 1 + " : " + type.name());
        }

        int num = gm.readNumber(values.length);

        if (num == -1) {
            gm.showMessage("入力が不正です");
            start();
            return;
        }

        Job job = new Job(values[num - 1]);

        GameApplication.current.setMainCharacter(new MainCharacter(job));

        // エリアシーンへ
        GameApplication.current.nextScene(new AreaScene(GameApplication.current.getMap().get(17)));

    }

    // 選択チェック
    private static int check(GameEngine gm, int max) {
        String str = gm.readLineFromUserInput();

        if (str == null || !str.matches("[0-9]")) {
            gm.showMessage("コマンドを入力しなおしてください");
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
