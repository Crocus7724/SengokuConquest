package sengoku_conquest.character;

import javafx.application.Application;
import sengoku_conquest.GameApplication;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Job {
    private int hp = 0;
    private int ep = 0;
    private SpecialAttack specialAttack;

    public int getHp() {
        return hp;
    }

    public int getEp() {
        return ep;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public JobType getType() {
        return type;
    }

    private int atk = 0;
    private int def = 0;

    JobType type;

    public Job(JobType type) {
        this.type = type;
        hp=type.getHp();
        atk=type.getAtk();
        def=type.getDef();
        ep=type.getEp();
    }

    // 特殊攻撃初期化処理
    public void initializeSpecialAtack(){

    }


    private SpecialAttack SamuraiAttack=new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage=calc(((int) (mainCharacter.getStatus().getAtk() * 1.45)),character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }
    };

    private SpecialAttack NinjaAttack=new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage=calc(((int) (mainCharacter.getStatus().getAtk() * 0.8)),character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {


        }
    };

    private SpecialAttack AshigaruAttack=new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage=calc((mainCharacter.getStatus().getAtk()),character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }
    };

    private SpecialAttack KomusouAttack=new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage=calc(((int) (mainCharacter.getStatus().getAtk() * 1.2)),character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);

            // 敵を倒したとき回復量変化
//            if(enemyHp<0){
//                damage += enemyHp;
//            }

            mainCharacter.getStatus().setCurrentHp(damage);

            if(mainCharacter.getStatus().getCurrentHp()>mainCharacter.getStatus().getMaxHp()){
                mainCharacter.getStatus().setCurrentHp(mainCharacter.getStatus().getMaxHp());
            }


        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }
    };
}
