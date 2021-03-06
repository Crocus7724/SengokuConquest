package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Character {
    private Status status;
    private String name;
    private int level = 0;

    public Character(Status status, String name, int level) {
        this.status = status;
        this.name = name;
        this.level = level;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    protected void setLevel(int level) {
        this.level=level;
    }

}
