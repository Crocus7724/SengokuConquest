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
| GameEngine | current | GameEngineクラス | GameEngineクラスのインスタンスを取得する |
| GameEngine | showMessage(String) | void | コンソールに引数の値を表示する |
| GameEngine | readLineFromUserInput() | String | ユーザの入力を取得する |
| GameEngine | readNumber(int) | int | ユーザからの入力を取得する　1〜引数の値以外の値が入力された場合-1が返ってくる |
| GameEngine | setIndentation(int) | void | インデントの値を設定する |

## 命名規則
基本的にはJavaの命名規則に則る

### パッケージ名
snake_case

```java
pacakge HogeHoge;//NG
pacakge hogeHoge;//NG
pacakge hoge_hoge;//OK
```

### クラス
PascalCase

```java
public class hogeHoge{
}//NG

public class Hoge_Hoge{
}//NG

public class HogeHoge{
}//OK
```

### メソッド
lowerCamelCase

```java
public void HogeHoge(){
}//NG

public void hoge_hoge(){
}//NG

public void hogeHoge(){
}//OK
```

### フィールド・ローカル変数・引数
lowerCamelCase

```java
public int HogeHoge=0;//NG
public int hoge_hoge=0;//NG
public int hogeHoge=0;//OK
```
