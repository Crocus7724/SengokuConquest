# SengokuConquest
実験Aのコンソールアプリ

---

## 値取得・設定用API

| クラス | メソッド(またはフィールド) | 戻り値 | 詳細 |
|-------|----------------------|------------|------|
| GameApplication | current | GameApplicationクラス | GameApplicationクラスのインスタンスを取得する |
| GameApplication | getMainCharacter() | MainCharacterクラス | プレイヤーが操るキャラクターの情報が入ったクラス |
| GameApplication | getTurn() | int | 現在のターンを取得する |
| GameApplication | setTurn(int) | void | 引数の値にターンを設定する
| GameApplication | decreaseTurn() | void | 1ターン減少させる |
| GameApplication | nexeScene(Scene) | void | 次のシーンへ行く |
| GameApplication | previousScene() | void | 前のシーンに戻る(使う予定あまりなし) |
| GameEngine | showMessage(String) | void | コンソールに引数の値を表示する |
| GameEngine | readLineFromUserInput() | String | ユーザの入力を取得する |
| GameEngine | readNumber(int) | int | ユーザからの入力を取得する　1〜引数の値以外の値が入力された場合-1が返ってくる |
| GameEngine | setIndentation(int) | void | インデントの値を設定する |
| GameEngine | showIndentMessage(String) | void | コンソールに引数の値を表示する　インデントの数字が0以上の場合、インデントの数字*4の空白がメッセージの前に表示される |

