package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public enum JobType {
    SAMURAI(105,100,100,5),
    NINJA(100,100,100,5),
    ASHIGARU(100,100,100,5),
    KOMUSOU(100,100,100,5),
    ;

    public int getHp() {
        return hp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getEp() {
        return ep;
    }

    private int hp;
    private int atk;
    private int def;
    private int ep;

    JobType(int hp, int atk, int def, int ep) {

        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.ep = ep;
    }
}
