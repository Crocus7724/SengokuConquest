package sengoku_conquest;

import sengoku_conquest.utilities.Action;
import sengoku_conquest.utilities.Predicate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by C0114544 on 2016/11/18.
 */

public final class GameEngine {
    public static final GameEngine current = new GameEngine();

    private int indentation=0;

    public void setIndentation(int indentation){
        this.indentation=indentation;
    }

    public void show(String message){
        System.out.print(getIndentation()+message);
    }

    public void showMessage(String message) {
        System.out.println(getIndentation()+message);
    }

    public String readLineFromUserInput() {
        String str = null;
        BufferedReader br=null;
        try {
            br=new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        } catch (IOException e) {
            return null;
        }

        return str;
    }

    /**
     * ユーザーから数字入力を待ちます
     * 返り値は-1のときは不正な値です
     *
     * @param range 正しい値の範囲(0~range)
     * @return ユーザからの入力
     */
    public int readNumber(final int range) {
        return readNumber(x -> x > 0 && x <= range);
    }

    /**
     * ユーザーから数字入力を待ちます
     * 返り値は-1のときは不正な値です
     *
     * @param predicate 入力された数字が正しいかの条件式
     * @return ユーザからの入力
     */
    public int readNumber(final Predicate<Integer> predicate) {
        final String input = readLineFromUserInput();

        if(input==null||input.isEmpty()||!input.matches("[0-9]"))return -1;

        int num=Integer.parseInt(input);

        if(!predicate.accept(num))return -1;

        return num;
    }

    public void showIndentedMessage(Action indentedMessage){
        indentation++;
        indentedMessage.accept();
        indentation--;
    }

    private String getIndentation(){
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<indentation;i++){
            builder.append("    ");
        }

        return builder.toString();
    }
}