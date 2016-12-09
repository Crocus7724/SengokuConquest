package sengoku_conquest.scene;

/**
 * Created by Yamamoto on 2016/11/18.
 */
public abstract class Scene {
    public void doStart() {
        start();
    }

    public void doEnd() {
        end();
    }

    public void doRestart() {
        restart();
    }

    abstract void start();

    abstract void end();

    abstract void restart();
}