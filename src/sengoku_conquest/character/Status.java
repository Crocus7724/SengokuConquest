package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Status {
    private int maxHp = 0;
    private int maxEp = 0;
    private int atk = 0;
    private int def = 0;

    public void setCurrentHp(int currentHp) {
        if (currentHp < 0) {
            this.currentHp = 0;
        } else {

            this.currentHp = currentHp;
        }
    }

    public void setCurrentEp(int currentEp) {
        if(currentEp<0){
            this.currentEp=0;
        }else {
            this.currentEp = currentEp;
        }
    }

    private int currentHp = 0;

    public int getMaxHp() {
        return maxHp;
    }

    public int getMaxEp() {
        return maxEp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentEp() {
        return currentEp;
    }

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
