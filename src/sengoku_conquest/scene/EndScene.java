package sengoku_conquest.scene;

import com.sun.org.apache.xpath.internal.operations.String;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public class  EndScene extends Scene{
    private GameEngine engine;

    public EndScene() {
        this.engine = new GameEngine();
    }

    @Override
    void start() {
        if(GameApplication.current.getTurn() <= 0){
            engine.showMessage("GAME OVER.../n" +
                    "THANK YOU FOR PLAYING.../n" +
                    "行動ターンがなくなってしまった！！/n" +
                    "           STAFF/n" +
                    "チームリーダー　　　江元和樹/n" +
                    "設計担当者　　　　　伊賀成寿/n" +
                    "プログラミング担当　山本一樹/n" +
                    "マーケテイング担当　山田諒　/n" +
                    "プレイ担当　　　　　YOU　　 /n");
        }
        if(GameApplication.current.getMainCharacter().getStatus().getCurrentHp() <= 0){
            engine.showMessage("GAME OVER.../n" +
                    "THANK YOU FOR PLAYING.../n" +
                    "戦闘に敗北してしまった...世界は暗黒に包まれた.../n" +
                    "           STAFF/n" +
                    "チームリーダー　　　江元和樹/n" +
                    "設計担当者　　　　　伊賀成寿/n" +
                    "プログラミング担当　山本一樹/n" +
                    "マーケテイング担当　山田諒　/n" +
                    "プレイ担当　　　　　YOU　　 /n");
        }

        else{
            engine.showMessage("どこかでバグが起きてるYO/n");
        }





        engine.showMessage("GAME CLEAR!!/n" +
                "THANK YOU FOR PLAYING!!/n" +
                "見事全国を制覇しました!!/n" +
                "           STAFF/n" +
                "チームリーダー　　　江元和樹/n" +
                "設計担当者　　　　　伊賀成寿/n" +
                "プログラミング担当　山本一樹/n" +
                "マーケテイング担当　山田諒　/n" +
                "プレイ担当　　　　　YOU　　 /n");

        System.exit(1);
    }

    @Override
    void end() {
     
    }

    @Override
    void restart() {

    }
}
