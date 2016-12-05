package sengoku_conquest.character;

import sengoku_conquest.const_values.Consts;

/**
 * Created by C011457331 on 2016/11/18.
 */
public enum JobType {
    SAMURAI(Consts.SAMURAI_INIT_HP,
            Consts.SAMURAI_INIT_ATTACK,
            Consts.SAMURAI_INIT_DEF,
            Consts.SAMURAI_INIT_EP),
    NINJA(Consts.NINJA_INIT_HP,
            Consts.NINJA_INIT_ATTACK,
            Consts.NINJA_INIT_DEF,
            Consts.NINJA_INIT_EP),
    ASHIGARU(Consts.ASHIGARU_INIT_HP,
            Consts.ASHIGARU_INIT_ATTACK,
            Consts.ASHIGARU_INIT_DEF,
            Consts.ASHIGARU_INIT_EP),
    KOMUSOU(Consts.KOMUSOU_INIT_HP,
            Consts.KOMUSOU_INIT_ATTACK,
            Consts.KOMUSOU_INIT_DEF,
            Consts.KOMUSOU_INIT_EP),
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
