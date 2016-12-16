package sengoku_conquest.character;

import java.util.ArrayList;
import java.util.List;

import sengoku_conquest.const_values.Consts;
import sengoku_conquest.item.Item;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class MainCharacter extends Character {
    private int exp = 0;
    private List<Item> items = new ArrayList<>();
    private Job job;

    public MainCharacter(Job job) {
        super(new Status(job.getHp(), job.getEp(), job.getAtk(), job.getDef()), job.getType().name(), Consts.INIT_PLAYER_LEVEL);
        this.job = job;
    }

    public void setExp(int exp) {
        this.exp += exp;
        int level = getLevel();

        if (getLevel() == 1 && this.exp >= Consts.REQUIRED_LEVEL2_EXP) {
            doLevelUp();
        }
        if (getLevel() == 2 && this.exp >= Consts.REQUIRED_LEVEL3_EXP) {
            doLevelUp();
        }
        if (getLevel() == 3 && this.exp >= Consts.REQUIRED_LEVEL4_EXP) {
            doLevelUp();
        }
        if (getLevel() == 4 && this.exp >= Consts.REQUIRED_LEVEL5_EXP) {
            doLevelUp();
        }
        if (getLevel() == 5 && this.exp >= Consts.REQUIRED_LEVEL6_EXP) {
            doLevelUp();
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

    private void doLevelUp() {
        int level = getLevel();
        level++;

        setLevel(level);

        final Status currentStatus = getStatus();
        Status nextStatus = new Status(
                currentStatus.getMaxHp() + Consts.INCREASE_HP_NEXT_LEVEL,
                currentStatus.getMaxEp(),
                currentStatus.getAtk() + Consts.INCREASE_ATTACK_NEXT_LEVEL,
                getStatus().getDef() + Consts.INCREASE_DEF_NEXT_LEVEL);
        setStatus(nextStatus);
        nextStatus.setCurrentHp(currentStatus.getCurrentHp() + Consts.INCREASE_HP_NEXT_LEVEL);
        nextStatus.setCurrentEp(currentStatus.getCurrentEp());

    }
}
