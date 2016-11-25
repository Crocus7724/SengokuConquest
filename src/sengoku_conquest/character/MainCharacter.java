package sengoku_conquest.character;

import sengoku_conquest.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class MainCharacter extends Character{
    private int exp = 0;
    private List<Item> items = new ArrayList<>();
    private Job job;

    public MainCharacter(Job job) {
        super(new Status(job.getHp(),job.getAtk(),job.getDef(),job.getEp()),job.getType().name(),1);
        this.job = job;
    }

    public void setExp(int exp) {
        this.exp = exp;
        int level = getLevel();

        if(level==1 && exp>=1
                || level==2 && exp>=4
                || level==3 && exp>=7
                || level==4 && exp>=10
                || level==5 && exp>=15
                ){
            level++;

            final Status currentStatus=getStatus();
            Status nextStatus = new Status(currentStatus.getMaxHp()+5, currentStatus.getCurrentEp(), currentStatus.getAtk()+2, getStatus().getDef()+2);
            setStatus(nextStatus);
            nextStatus.setCurrentHp(nextStatus.getCurrentHp()+5);
            nextStatus.setCurrentEp(nextStatus.getCurrentEp());
        }
    }

    public int getExp() {
        return exp;
    }

    public List<Item> getItems() {
        return items;
    }

    public Job getJob() {
        return job;
    }
}
