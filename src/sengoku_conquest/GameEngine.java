package sengoku_conquest;

import sengoku_conquest.utilities.Action;
import sengoku_conquest.utilities.Predicate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by C0114544 on 2016/11/18.
 */

public final class GameEngine {
    public static final GameEngine current = new GameEngine();

    private int indentation=0;

    public void setIndentation(int indentation){
        this.indentation=indentation;
    }

    public void showMessage(String message) {
        System.out.println(getIndentation()+message);
    }

    public String readLineFromUserInput() {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            return null;
        } finally {
            try {
                br.close();
            } catch (IOException ignored) {
            }

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
        return readNumber(x -> x > 0 || x <= range);
    }

    /**
     * ユーザーから数字入力を待ちます
     * 返り値は-1のときは不正な値です
     *
     * @param predicate 入力された数字が正しいかの条件式
     * @return ユーザからの入力
     */
    public int readNumber(final Predicate<Integer> predicate) {
        BufferedReader br = null;
        int num = -1;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            final String read = br.readLine();

            if (read.isEmpty() || !read.matches("[0-9]")) return -1;

            num = Integer.parseInt(read);

            if (!predicate.accept(num)) return -1;

        } catch (IOException e) {
            return -1;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException ignored) {
                }
            }
        }

        return num;
    }

    public void showIndentedMessage(Action indentedMessage){
        indentation++;
        indentedMessage.accept();
        indentation--;
    }

    private String getIndentation(){
        String s="";
        for (int i=0;i<indentation;i++){
            s+="    ";
        }

        return s;
    }
}