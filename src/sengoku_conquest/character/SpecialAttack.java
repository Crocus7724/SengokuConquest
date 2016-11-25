package sengoku_conquest.character;

import java.util.Random;

/**
 * Created by C011457331 on 2016/11/25.
 */
public abstract class SpecialAttack {
    private static Random r=new Random(100000);
    abstract void attack(EnemyCharacter character);
    abstract void didAttacked(EnemyCharacter character);

    protected int calc(int attacker,int deffender){
        return attacker-deffender+getRandomDamage();
    }

    private int getRandomDamage(){
        return r.nextInt(3)-1;
    }
}
