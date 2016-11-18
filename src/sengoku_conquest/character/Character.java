package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Character {
    private Status status;

    public Character(Status status, String name, int level) {
        this.status = status;
        this.name = name;
        this.level = level;
    }

    private String name;
    private int level = 0;

    public Status getStatus() {
        return status;
    }


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }
}
