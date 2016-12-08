package sengoku_conquest.character;

import sengoku_conquest.const_values.Consts;

import java.util.Random;

/**
 * Created by C011457331 on 2016/11/25.
 */
public abstract class SpecialAttack {
    private static Random r=new Random(100000);
    public abstract void attack(EnemyCharacter character);
    public abstract void didAttacked(EnemyCharacter character);
    public abstract String getName();

    protected int calc(int attacker,int defender){
        return attacker-defender+getRandomDamage();
    }

    private int getRandomDamage(){
        return r.nextInt(Consts.RANDOM_DAMAGE_RANGE)-1;
    }
}
