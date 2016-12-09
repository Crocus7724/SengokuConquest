package sengoku_conquest.const_values;

/**
 * Created by Yamamoto on 2016/12/04.
 * 定数の値を定義するところ
 */
public class Consts {

    /*******************************************
     システムの定数値
     *******************************************/

    /**
     * マップの縦幅
     */
    public static final int MAP_MAX_VERTICAL = 6;
    /**
     * マップの横幅
     */
    public static final int MAP_MAX_WIDTH = 7;
    /**
     * 最初の所持ターン数
     */
    public static final int INITIAL_TURN = 25;

    /**
     * 回復するターン数
     */
    public static final int RECOVERY_TURN = 10;

    /**
     * ターンが回復する条件(killCountの倍数)
     */
    public static final int RECOVERY_TURN_CONDITION = 3;

    /**
     * ボスに挑める最低レベル
     */
    public static final int BOSS_CHALLENGE_LEVEL_CONDITION = 3;

    public static final int START_POSITION = 17;

    public static final int BOSS_POSITION = 14;

    public static final int RANDOM_DAMAGE_RANGE = 3;

    /*******************************************
     プレイヤーの定数値
     *******************************************/

    /**
     * 侍の初期HP
     */
    public static final int SAMURAI_INIT_HP = 105;

    /**
     * 侍の初期攻撃力
     */
    public static final int SAMURAI_INIT_ATTACK = 50;

    /**
     * 侍の初期防御力
     */
    public static final int SAMURAI_INIT_DEF = 30;

    /**
     * 侍の初期EP
     */
    public static final int SAMURAI_INIT_EP = 3;

    /**
     * 忍者の初期HP
     */
    public static final int NINJA_INIT_HP = 85;

    /**
     * 忍者の初期攻撃力
     */
    public static final int NINJA_INIT_ATTACK = 60;

    /**
     * 忍者の初期防御力
     */
    public static final int NINJA_INIT_DEF = 30;

    /**
     * 忍者の初期EP
     */
    public static final int NINJA_INIT_EP = 2;

    /**
     * 足軽の初期HP
     */
    public static final int ASHIGARU_INIT_HP = 110;

    /**
     * 足軽の初期攻撃力
     */
    public static final int ASHIGARU_INIT_ATTACK = 40;

    /**
     * 足軽の初期防御力
     */
    public static final int ASHIGARU_INIT_DEF = 36;

    /**
     * 足軽の初期EP
     */
    public static final int ASHIGARU_INIT_EP = 4;

    /**
     * 虚無僧の初期HP
     */
    public static final int KOMUSOU_INIT_HP = 90;

    /**
     * 虚無僧の初期攻撃力
     */
    public static final int KOMUSOU_INIT_ATTACK = 45;

    /**
     * 虚無僧の初期防御力
     */
    public static final int KOMUSOU_INIT_DEF = 30;

    /**
     * 虚無僧の初期EP
     */
    public static final int KOMUSOU_INIT_EP = 4;

    /**
     * 初期プレイヤーレベル
     */
    public static final int INIT_PLAYER_LEVEL = 1;

    /**
     * LEVEL2に必要な経験値
     */
    public static final int REQUIRED_LEVEL2_EXP = 1;

    /**
     * LEVEL3に必要な経験値
     */
    public static final int REQUIRED_LEVEL3_EXP = 4;

    /**
     * LEVEL4に必要な経験値
     */
    public static final int REQUIRED_LEVEL4_EXP = 7;

    /**
     * LEVEL5に必要な経験値
     */
    public static final int REQUIRED_LEVEL5_EXP = 10;

    /**
     * LEVEL6に必要な経験値
     */
    public static final int REQUIRED_LEVEL6_EXP = 15;

    /**
     * レベルアップ時のHPの増加分
     */
    public static final int INCREASE_HP_NEXT_LEVEL = 5;

    /**
     * レベルアップ時の攻撃力の増加分
     */
    public static final int INCREASE_ATTACK_NEXT_LEVEL = 2;

    /**
     * レベルアップ時の防御力の増加分
     */
    public static final int INCREASE_DEF_NEXT_LEVEL = 2;

    /*******************************************
     アイテムの定数値
     *******************************************/

    /**
     * HPアイテムの回復量
     */
    public static final int RECOVERY_HP_VALUE = 50;

    /**
     * EPアイテムの回復量
     */
    public static final int RECOVERY_EP_VALUE = 3;

    /*******************************************
     敵キャラクターの定数値
     *******************************************/

    /**
     * ボス特殊攻撃倍率
     */
    public static final double BOSS_SPECIAL_ATTACK = 1.43;

    /**
     * LEVEL1敵キャラのHP
     */
    public static final int LEVEL1_ENEMY_HP = 70;

    /**
     * LEVEL1敵キャラのEP
     */
    public static final int LEVEL1_ENEMY_EP = 0;

    /**
     * LEVEL1敵キャラの攻撃力
     */
    public static final int LEVEL1_ENEMY_ATTACK = 50;

    /**
     * LEVEL1敵キャラの防御力
     */
    public static final int LEVEL1_ENEMY_DEF = 20;

    /**
     * LEVEL2敵キャラのHP
     */
    public static final int LEVEL2_ENEMY_HP = 80;

    /**
     * LEVEL2敵キャラのEP
     */
    public static final int LEVEL2_ENEMY_EP = 0;

    /**
     * LEVEL2敵キャラの攻撃力
     */
    public static final int LEVEL2_ENEMY_ATTACK = 55;

    /**
     * LEVEL2敵キャラの防御力
     */
    public static final int LEVEL2_ENEMY_DEF = 25;

    /**
     * LEVEL3敵キャラのHP
     */
    public static final int LEVEL3_ENEMY_HP = 90;

    /**
     * LEVEL3敵キャラのEP
     */
    public static final int LEVEL3_ENEMY_EP = 0;

    /**
     * LEVEL3敵キャラの攻撃力
     */
    public static final int LEVEL3_ENEMY_ATTACK = 60;

    /**
     * LEVEL3敵キャラの防御力
     */
    public static final int LEVEL3_ENEMY_DEF = 30;

    /**
     * LEVEL4敵キャラのHP
     */
    public static final int LEVEL4_ENEMY_HP = 150;

    /**
     * LEVEL4敵キャラのEP
     */
    public static final int LEVEL4_ENEMY_EP = 1;

    /**
     * LEVEL4敵キャラの攻撃力
     */
    public static final int LEVEL4_ENEMY_ATTACK = 66;

    /**
     * LEVEL4敵キャラの防御力
     */
    public static final int LEVEL4_ENEMY_DEF = 35;

    /**
     * ボスの特殊攻撃をする条件(HP)
     */
    public static final int BOSS_SPECIAL_ATTACK_CONDITION = 70;

    /**
     * EPアイテムを取得する条件(敵エネミーレベル)
     */
    public static final int FIND_ITEM_CONDITION = 2;
}
