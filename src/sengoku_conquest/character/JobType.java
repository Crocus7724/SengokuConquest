package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public enum JobType {
    SAMURAI(105,50,30,3),
    NINJA(85,60,30,2),
    ASHIGARU(110,40,35,4),
    KOMUSOU(90,45,30,4),
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
