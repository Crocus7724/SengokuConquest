package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Job {
    private int hp = 0;
    private int ep = 0;

    public int getHp() {
        return hp;
    }

    public int getEp() {
        return ep;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public JobType getType() {
        return type;
    }

    private int atk = 0;
    private int def = 0;

    JobType type;

    public Job(JobType type) {
        this.type = type;
        hp=type.getHp();
        atk=type.getAtk();
        def=type.getDef();
        ep=type.getEp();
    }

    // 特殊攻撃初期化処理
    public void initializeSpecialAtack(){

    }

}
