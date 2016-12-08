package sengoku_conquest.character;

import sengoku_conquest.GameApplication;
import sengoku_conquest.GameEngine;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.utilities.DamageCalcurator;

/**
 * Created by C011457331 on 2016/11/18.
 */
public class Job {
    private int hp = 0;
    private int ep = 0;
    private int atk = 0;
    private int def = 0;
    private JobType type;
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

    public Job(JobType type) {
        this.type = type;
        hp = type.getHp();
        atk = type.getAtk();
        def = type.getDef();
        ep = type.getEp();
        switch (type) {
            case SAMURAI:
                specialAttack = SamuraiAttack;
                break;
            case NINJA:
                specialAttack = NinjaAttack;
                break;
            case ASHIGARU:
                specialAttack = AshigaruAttack;
                break;
            case KOMUSOU:
                specialAttack = KomusouAttack;
                break;
        }
    }

    public SpecialAttack getSpecialAttack() {
        return specialAttack;
    }

    private SpecialAttack SamuraiAttack = new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage = calc(((int) (mainCharacter.getStatus().getAtk() * 1.45)), character.getStatus().getDef());
            GameEngine.current.showFormattedMessage(Strings.DAMAGE, character.getName(), damage);
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp() - damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }

        @Override
        public String getName() {
            return Strings.SPECIAL_ATTACK_SAMURAI;
        }
    };

    private SpecialAttack NinjaAttack = new SpecialAttack() {
        private int hpBeforeAttacked;
        private MainCharacter mainCharacter;

        @Override
        public void attack(EnemyCharacter character) {
            mainCharacter = GameApplication.current.getMainCharacter();
            hpBeforeAttacked = mainCharacter.getStatus().getCurrentHp();
            int damage = calc(((int) (mainCharacter.getStatus().getAtk() * 0.8)), character.getStatus().getDef());
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp() - damage);
            GameEngine.current.showFormattedMessage(Strings.DAMAGE, character.getName(), damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {
            GameEngine.current.showMessage(Strings.SCAPEGOATED);
            mainCharacter.getStatus().setCurrentHp(hpBeforeAttacked);
        }

        @Override
        public String getName() {
            return Strings.SPECIAL_ATTACK_NINJA;
        }
    };

    private SpecialAttack AshigaruAttack = new SpecialAttack() {
        private MainCharacter mainCharacter;
        private int hpBeforeAttacked;

        @Override
        public void attack(EnemyCharacter character) {
            mainCharacter = GameApplication.current.getMainCharacter();
            hpBeforeAttacked = mainCharacter.getStatus().getCurrentHp();
            int damage = calc((mainCharacter.getStatus().getAtk()), character.getStatus().getDef());
            GameEngine.current.showFormattedMessage(Strings.DAMAGE, character.getName(), damage);
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp() - damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {
            GameEngine.current.showFormattedMessage(Strings.COUNTER_ATTACK, mainCharacter.getName());
            final int damage = hpBeforeAttacked - mainCharacter.getStatus().getCurrentHp();
            character.getStatus().setCurrentHp(character.getStatus().getCurrentHp() - damage);
            GameEngine.current.showFormattedMessage(Strings.DAMAGE, character.getName(), damage);
        }

        @Override
        public String getName() {
            return Strings.SPECIAL_ATTACK_ASHIGARU;
        }
    };

    private SpecialAttack KomusouAttack = new SpecialAttack() {
        @Override
        public void attack(EnemyCharacter character) {
            MainCharacter mainCharacter = GameApplication.current.getMainCharacter();
            int damage = DamageCalcurator.calc(((int) (mainCharacter.getStatus().getAtk() * 1.2)), character.getStatus().getDef());
            GameEngine.current.showFormattedMessage(Strings.DAMAGE, character.getName(), damage);
            int didDamage = character.getStatus().getCurrentHp() - damage;
            if (didDamage < 0) {
                damage = character.getStatus().getCurrentHp();
            }
            character.getStatus().setCurrentHp(didDamage);

            GameEngine.current.showFormattedMessage(Strings.RECOVERY_DAMAGE, mainCharacter.getName(), damage);
            mainCharacter.getStatus().setCurrentHp(mainCharacter.getStatus().getCurrentHp() + damage);
        }

        @Override
        public void didAttacked(EnemyCharacter character) {

        }

        @Override
        public String getName() {
            return Strings.SPECIAL_ATTACK_KOMUSOU;
        }
    };
}
