package sengoku_conquest.character;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class EnemyCharacter extends Character {
    public EnemyCharacter(String name, int level) {
        super(initStatus(level), name, level);
    }
//    private int pops = 0;

    public int doSpecialAtack() {
        return 0;
    }

    private static Status initStatus(int level){
        switch (level){
            case 1:
                return new Status(70,0,50,20);
            case 2:
                return new Status(80,0,55,25);
            case 3:
                return new Status(90,0,60,30);
            case 4:
                return new Status(150,1,66,35);
        }

        return null;
    }
}



