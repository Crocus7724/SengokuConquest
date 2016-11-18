package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Status {
    private int maxHp = 0;
    private int maxEp = 0;
    private int atk = 0;
    private int def = 0;
    private int currentHp = 0;
    private int currentEp = 0;

    public Status(int maxHp, int maxEp, int atk, int def) {
        this.maxHp = maxHp;
        this.maxEp = maxEp;
        this.atk = atk;
        this.def = def;
        this.currentHp=maxHp;
        this.currentEp=maxEp;
    }
}
