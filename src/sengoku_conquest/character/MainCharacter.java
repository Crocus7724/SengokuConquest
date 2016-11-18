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
