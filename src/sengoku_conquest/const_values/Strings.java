package sengoku_conquest.const_values;

/**
 * Created by Yamamoto on 2016/12/02.
 * 固定文字を入れるところ
 */
public class Strings {

    public final static String TITLE ="+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+\n" +
            "|S|e|n|g|o|k|u| |C|o|n|q|u|e|s|t|\n" +
            "+-+-+-+-+-+-+-+ +-+-+-+-+-+-+-+-+";

    /**
     * ストーリー
     */
    public final static String STORY = "主人公は激怒した。必ず、かの邪智暴虐の魔王を除かなければならぬと決意した。主人公には政治がわからぬ。けれども邪悪に対しては、人一倍に敏感であった。\n" +
            "「呆れた魔王だ。生かして置けぬ。」\n" +
            "　主人公は捕縛され、「第六天魔王　織田信長」の前に引き出された。\n" +
            "「何をするつもりであったか。言え！」\n" +
            "「都を魔王の手から救うのだ。」\n" +
            "「だまれ、下賤の者。お前だって、磔になってから泣いて詫びたって聞かぬぞ。」\n" +
            "「自惚れているがよい。ただ、私に情をかけたいつもりなら、処刑までに25ターンの限を与えて下さい。必ず、ここへ帰って来ます。」\n" +
            "　「ばかな。逃がした小鳥が帰って来るというのか。」\n" +
            "「そうです。帰って来るのです。私は約束を守ります。この都に竹馬の友がいます。人質としてここに置いて行こう。私が帰って来なかったら、あの友を殺して下さい。」\n" +
            "「願いを、聞いた。その身代りを呼ぶがよい。ちょっと遅れて来るがいい。おまえの罪は、永遠にゆるしてやろう。」\n" +
            "「何をおっしゃる。」主人公は地団駄踏んだ。ものも言いたくなくなった。\n" +
            "　竹馬の友は王城に召された。主人公は、友に一切の事情を語った。友は無言で首肯き、主人公をひしと抱きしめた。友と友の間は、それでよかった。主人公は、すぐに出発した。\n" +
            "　初夏、満天の星である。\n";
    /**
     * ゲームルール
     */
    public final static String RULE = "ルール\n" +
            "　日本を旅して大名を倒しレベルを上げて、竹馬の友のために織田信長を倒そう\n" +
            "　レベル4にならないと織田信長に挑めないぞ\n" +
            "　戦闘に敗北もしくはターンが0になると敗北するので気をつけよう\n" +
            "コマンド説明\n" +
            "　移動　1ターン消費しマップの隣り合うマス東西南北に1マス移動\n" +
            "　休憩　1ターン消費しHP30回復\n" +
            "　ステータスを表示する　主人公のステータスを表示\n" +
            "　アイテム使用　アイテムを使用(アイテム所持時表示)\n" +
            "　            　握り飯：HP50回復,　いにしえの秘薬：EP3回復　　※回復は最大値を超えることはない\n" +
            "　通常攻撃　ATK値攻撃\n" +
            "　特殊攻撃　EPを1消費する攻撃\n" +
            "　逃走　　　1ターン消費し1マス戻る(織田信長以外は必ず逃げられる)\n" +
            "職業説明\n" +
            "　SAMURAI(侍)　   難易度：普通  　　HP105 ATK50 DEF30 EP3\n"+
            "　                特殊攻撃：居合切り(通常攻撃の1.45倍ダメージ)\n" +
            "　NINJA(忍者)   　難易度：やさしい  HP85 ATK60 DEF30 EP2\n" +
            "　　　            特殊攻撃：変わり身の術(通常攻撃の0.8倍ダメージ、次の攻撃のダメージを受けない)\n" +
            "　ASHIGARU(足軽)　難易度：難しい 　 HP110 ATK40 DEF36 EP4\n" +
            "　　　            特殊攻撃：一揆(通常攻撃ダメージ、次の敵攻撃時反撃(自分が受けたダメージを与える))\n" +
            "　KOMUSOU(虚無僧) 難易度：やさしい  HP90 ATK45 DEF30 EP4\n" +
            "　　            　特殊攻撃：吸魂(通常攻撃の1.2倍ダメージ、減らした体力分回復)\n" +
            "　※ステータスはLevel1の時のものです\n" +
            "ヒント\n" +
            "　マップアイコン　P：主人公,　S：織田信長(ボス),　A：Level3の敵,　B：Level2の敵,　C：Level1の敵\n" +
            "　大名は織田信長を含め9人いるぞ、主人公は最大レベル6まで強化できるぞ\n" +
            "　HP回復アイテムはマップに3つ隠れているぞ\n" +
            "　敵のレベルが自分のレベルより2つ高いと敵に勝つのは難しいぞ\n" +
            "　戦闘中アイテムは使えないが逃げたときの敵の体力は持ち越しされるぞ\n" +
            "　織田信長は体力が低くなると特殊攻撃を使うので挑む前に準備が大切だ\n";

    public static final String STAFF_ROLL = "THANK YOU FOR PLAYING...\n" +
            "           STAFF\n" +
            "チームリーダー　　　江元和樹\n" +
            "設計担当者　　　　　伊賀成寿\n" +
            "プログラミング担当　山本一樹\n" +
            "マーケテイング担当　山田諒　\n" +
            "プレイ担当　　　　　YOU　　 \n";

    public static final String GAME_OVER = "GAME OVER...";

    public static final String GAME_CLEAR = "GAME CLEAR!!";

    public static final String GAME_OVER_NOTING_TURN = "\n行動ターンがなくなってしまった！！\n\n" +
            "流石に疲労し、がくりと膝を折った。立ち上る事が出来ぬのだ。\n" +
            "ああ、ここまで走破して来た主人公よ。真の勇者よ。今、ここで、動けなくなるとは情け無い。\n" +
            "　全身萎えて、もはや芋虫ほどにも前進かなわぬ。私は、この大事な時に、精も根も尽きたのだ。\n" +
            "友よ、許してくれ。私たちは、本当に佳い友と友であったのだ。\n" +
            "――私は、死ぬよりつらい。私は、永遠に裏切り者だ。\n";

    public static final String GAME_OVER_BATTLE_ = "\n戦闘に敗北してしまった...\n\n" +
            "呼吸も出来ず、二度、三度、口から血が噴き出た。立ち上る事が出来ぬのだ。\n" +
            "ああ、ここまで突破して来た主人公よ。真の勇者よ。今、ここで、動けなくなるとは情け無い。\n" +
            "全身傷つき、もはや蟻一匹ほどにも戦うことができぬ。私は、この大事な時に、血も魂も尽きたのだ\n。" +
            "友よ、許してくれ。私たちは、本当に佳い友と友であったのだ。\n" +
            "――私は、死ぬよりつらい。私は、永遠に裏切り者だ。\n";

    public static final String GAME_CON = "　ふと水の流れる音が聞えた。息を呑んでそっと耳をすました。すぐ足もとで、岩の裂け目から清水が湧き出ているのである。その泉に吸い込まれるように身をかがめた。水を一くち飲んだ。\n" +
            "　ほうと長い溜息が出て、夢から覚めたような気がした。わずかながら希望が生れた。義務遂行の希望である。わが身を殺して、名誉を守る希望である。\n" +
            "　処刑までには、まだ間がある。私を、待っている人があるのだ。私の命なぞは、問題ではない。私は、信頼に報いなければならぬ。いまはただその一事だ。走れ！\n\n";

    public static final String GAME_OVER_CLEAR = "\n「待て。その人を殺してはならぬ。私が帰って来た。約束のとおり、いま、帰って来た。魔王は打ち倒された。殺したのは、私だ。友を人質にした私は、ここにいる！」\n" +
            "と、かすれた声で叫びながら、磔台に釣り上げられてゆく友の両足に齧りついた。\n" +
            "友の縄は、ほどかれたのである。\n" +
            "「友よ。私を殴れ。君が若し私を殴ってくれなかったら、私は君と抱擁する資格さえ無いのだ。殴れ。」\n" +
            "友は、すべてを察した様子で首肯き、刑場一杯に鳴り響くほど音高く殴った。殴ってから優しく微笑み、\n" +
            "「友よ、私を殴れ。同じ位私の頬を殴れ。君が私を殴ってくれなければ、私は君と抱擁できない。」\n" +
            "　主人公は腕に唸りをつけて殴った。\n" +
            "「「ありがとう、友よ。」」\n" +
            "二人同時に言い、ひしと抱き合い、それから嬉し泣きにおいおい声を放って泣いた。\n\n";

    public static final String DAMAGE = "%sに%dのダメージ!!";

    /**
     * ボスの名前
     */
    public static final String BOSS_NAME = "織田信長";

    /**
     * 侍の特殊攻撃名
     */
    public static final String SPECIAL_ATTACK_SAMURAI = "居合い斬り";

    /**
     * 忍者の特殊攻撃名
     */
    public static final String SPECIAL_ATTACK_NINJA = "変わり身の術";

    /**
     * 足軽の特殊攻撃名
     */
    public static final String SPECIAL_ATTACK_ASHIGARU = "一揆";

    /**
     * 虚無僧の特殊攻撃名
     */
    public static final String SPECIAL_ATTACK_KOMUSOU = "吸魂";

    /**
     * HPアイテム名
     */
    public static final String HP_ITEM_NAME = "握り飯(HP50回復)";

    /**
     * EPアイテム名
     */
    public static final String EP_ITEM_NAME = "いにしえの秘薬(EP3回復)";

    public static final String SCAPEGOATED = "しかし、身代わりだった!!";

    public static final String COUNTER_ATTACK = "%sの反撃!!";

    public static final String RECOVERY_DAMAGE = "%sは%d回復した!!";

    /**
     * 逃走コマンド名
     */
    public static final String ESCAPE_COMMAND_NAME = "逃走";

    public static final String MOVE_COMMAND_NAME = "移動";

    public static final String ITEM_COMMAND_NAME = "アイテム使用";

    public static final String NORMAL_ATTACK_COMMAND_NAME = "通常攻撃";

    public static final String REST_COMMAND_NAME = "休憩";

    public static final String SHOW_STATUS_COMMAND_NAME = "ステータスを表示する";

    public static final String SHOW_ITEM = "%s : %d個";

    public static final String NOT_USE = "使用しない";

    public static final String REALLY_ESCAPE = "本当に逃走しますか?";

    public static final String QUESTION_REST = "1ターン消費してHPを30回復します。よろしいですか？";

    public static final String SELECTED_USE_ITEM = "使用するアイテムを選択して下さい";

    public static final String APPEAR_ENEMY = "%s LEVEL:%dが現れた!!";

    public static final String FIND_ITEM = "%sを手に入れた!";

    public static final String FULL_HP = "HPは満タンです!";

    public static final String FULL_EP = "EPは満タンです!";

    public static final String RECOVERY_HP = "HPを回復しました";

    public static final String RECOVERY_EP = "EPを回復しました";

    public static final String NOT_HAVE_EP = "EPが足りません";

    public static final String ATTACK = "%sの攻撃!";

    public static final String CHARGE_BOSS = "%sは力を溜めている・・・";

    public static final String SPECIAL_ATTACK_BOSS = "%sは全ての力を解き放った!!";

    public static final String USE_SPECIAL_ATTACK = "%sは%sを使った!";

    public static final String ESCAPED = "逃走した!";

    public static final String KILL_ENEMY = "%sを倒した!!";

    public static final String RECOVERY_TURN = "%dターン回復した!";

    public static final String GET_EXP = "%sは%d経験値を手に入れた!";

    public static final String LEVEL_UP = "レベルが上った!!";

    public static final String ENEMY_HP = "敵HP : ";

    public static final String HP = "HP : %d";

    public static final String EP = "EP : %d";

    public static final String LEVEL = "LEVEL : %d";

    public static final String EAST = "東";

    public static final String NORTH = "北";

    public static final String SOUTH = "南";

    public static final String WEST = "西";

    public static final String CURRENT_POSITION = "現在位置 : %d";

    public static final String CURRENT_TURN = "ターン数 : %d";

    public static final String SELECT_COMMAND = "コマンドを入力して下さい";

    public static final String INVALID_BOSS_CHALLENGE = "不思議なチカラで阻まれた!";

    public static final String BOSS_EXISTS = "%sがこの先にいます。";

    public static final String BOSS_CHALLENGE = "%sに挑みますか?";

    public static final String YES = "はい";

    public static final String NO = "いいえ";

    public static final String RETURN = "戻る";

    public static final String INVALID_INPUT = "入力に誤りがあります";

    public static final String SHOW_STORY = "物語を読む";

    public static final String SHOW_RULE = "ルール表示";

    public static final String GAME_START = "ゲームスタート";

    public static final String SELECT_JOB = "職業を選択して下さい";

    public static final String JOB_SAMURAI = "特殊攻撃で攻撃を食らう前に敵を撃破できる";

    public static final String JOB_NINJA = "EP少ないが連続で攻撃できる特殊攻撃が強力";

    public static final String JOB_ASHIGARU = "道中難しいがボスに強い";

    public static final String JOB_KOMUSOU = "レベル低い敵から多くの体力を奪える";

    /**
     * 空白でない不可視文字(マップ表示用)
     */
    public static final String ANVISIBLE_CHARACTER = " ";
}
