package sengoku_conquest.character;

import javafx.application.Application;
import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;

import static sengoku_conquest.character.JobType.ASHIGARU;
import static sengoku_conquest.character.JobType.KOMUSOU;
import static sengoku_conquest.character.JobType.NINJA;

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
        switch (type){
            case SAMURAI:
                specialAttack=SamuraiAttack;
                break;
            case NINJA:
                specialAttack=NinjaAttack;
                break;
            case ASHIGARU:
                specialAttack=AshigaruAttack;
                break;
            case KOMUSOU:
                specialAttack=KomusouAttack;
                break;
        }
    }

    public SpecialAttack getSpecialAttack() {
        return specialAttack;
    }

    private SpecialAttack SamuraiAttack=new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage=calc(((int) (mainCharacter.getStatus().getAtk() * 1.45)),character.getStatus().getDef());
            GameEngine.current.showMessage(character.getName()+"に"+damage+"のダメージを与えた!!");
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }

        @Override
        public String getName() {
            return "居合切り";
        }
    };

    private SpecialAttack NinjaAttack=new SpecialAttack() {
        private int hpBeforeAttacked;
        private MainCharacter mainCharacter;
        @Override
        public void attack(EnemyCharacter character) {
            mainCharacter= GameApplication.current.getMainCharacter();
            hpBeforeAttacked=mainCharacter.getStatus().getCurrentHp();
            int damage=calc(((int) (mainCharacter.getStatus().getAtk() * 0.8)),character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
            GameEngine.current.showMessage(character.getName()+"に"+damage+"のダメージを与えた");
        }

        @Override
        public void didAttacked(EnemyCharacter character) {
            GameEngine.current.showMessage("しかし、身代わりだった!!");
            mainCharacter.getStatus().setCurrentHp(hpBeforeAttacked);
        }

        @Override
        public String getName() {
            return "変わり身の術";
        }
    };

    private SpecialAttack AshigaruAttack=new SpecialAttack() {
        private MainCharacter mainCharacter;
        private int hpBeforeAttacked;
        @Override
        public void attack(EnemyCharacter character) {
            mainCharacter= GameApplication.current.getMainCharacter();
            hpBeforeAttacked=mainCharacter.getStatus().getCurrentHp();
            int damage=calc((mainCharacter.getStatus().getAtk()),character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp()-damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }

        @Override
        public String getName() {
            return "一揆";
        }
    };

    private SpecialAttack KomusouAttack=new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage=calc(((int) (mainCharacter.getStatus().getAtk() * 1.2)),character.getStatus().getDef());
            GameEngine.current.showMessage(character.getName()+"に"+damage+"のダメージを与えた");
            int didDamage = character.getStatus().getCurrentHp() - damage;
            if (didDamage < 0) {
                didDamage=character.getStatus().getCurrentHp();
            }
            character.getStatus().setCurrentHp(didDamage);

            GameEngine.current.showMessage(mainCharacter.getName()+"は"+didDamage+"回復した!!");
            mainCharacter.getStatus().setCurrentHp(didDamage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }

        @Override
        public String getName() {
            return "吸魂";
        }
    };
}
