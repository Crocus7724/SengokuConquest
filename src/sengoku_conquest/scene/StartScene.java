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
        GameEngine gm = new GameEngine();
        gm.showMessage("0：ルール表示");
        gm.showMessage("1：ゲームスタート");
        String input = gm.readLineFromUserInput();

        // ルール表示
        if (input.equals("0")) {
            gm.showMessage("ここにルールを表示");
        }

        // ゲーム開始
        if (input.equals("1")) {
            gm.showMessage("職を選択してください");
            JobType[] values = JobType.values();
            for (int i = 0; i < values.length; i++) {
                JobType type = values[i];
                gm.showMessage(i + " : " + type.name());
            }

            // Job選択
            String str = gm.readLineFromUserInput();
            if (str==null|| !str.matches("[0-9]")){
                gm.showMessage("値に誤りがあります");
                start();
            }

            int num = Integer.parseInt(str);

            if (num<0||num>values.length){
                gm.showMessage("値に誤りがあります");
                start();
            }

            Job job = new Job(values[num]);

            GameApplication.current.setMainCharacter(new MainCharacter(job));


            // エリアシーンへ


        }
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }

}
