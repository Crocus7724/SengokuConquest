package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Job {
    private int Hp = 0;
    private int Ep = 0;

    public int getHp() {
        return Hp;
    }

    public int getEp() {
        return Ep;
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
        Hp=type.getHp();
    }

}
