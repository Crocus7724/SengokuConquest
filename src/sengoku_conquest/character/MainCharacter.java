package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class MainCharacter extends Character{
    private int exp = 0;
    private int items = 0;

    public MainCharacter(Job job) {
        super(new Status(job.getHp(),job.getAtk(),job.getDef(),job.getEp()),job.getType().name(),1);
        this.job = job;
    }

    Job job;
}
