package sengoku_conquest.character;

import sengoku_conquest.const_values.Strings;

/**
 * Created by C0114105 on 2016/11/25.
 */
public class BossCharacter extends EnemyCharacter {
    public boolean isCharged;//ためたのかどうか
    public BossCharacter(){
        super(Strings.BOSS_NAME,4);
        this.isCharged = false;
    }

    public boolean getIsCharged(){return isCharged;}
    //↑一応作ったけどいるかどうか不明メソッド名も仮

    public void setCharged(boolean charged) {
        isCharged = charged;
    }
}
