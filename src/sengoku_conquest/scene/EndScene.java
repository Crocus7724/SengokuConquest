package sengoku_conquest.scene;

import com.sun.org.apache.xpath.internal.operations.String;

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
        engine.showMessage("GAME CLEAR!!/n" +
                "THANK YOU FOR PLAYING!!/n" +
                "見事全国を制覇しました!!/n" +
                "チームリーダー　　　江元和樹/n" +
                "設計担当者　　　　　伊賀成寿/n" +
                "プログラミング担当　山本一樹/n" +
                "マーケテイング担当　山田諒　/n" +
                "プレイ担当　　　　　YOU　　 /n");
    }

    @Override
    void end() {

    }

    @Override
    void restart() {

    }
}
