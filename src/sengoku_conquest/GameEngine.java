package sengoku_conquest;

import sengoku_conquest.character.MainCharacter;
import sengoku_conquest.utilities.Action;
import sengoku_conquest.utilities.ArtGenerater;
import sengoku_conquest.utilities.Predicate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by C0114544 on 2016/11/18.
 */

public final class GameEngine {
    public static final GameEngine current = new GameEngine();

    public static Formatter getFormatter() {
        return new Formatter();
    }

    private int indentation = 0;

    public void setIndentation(int indentation) {
        this.indentation = indentation;
    }

    public void show(String message) {
        System.out.print(getIndentation() + message);
    }

    public void showMessage(String message) {
        System.out.println(getIndentation() + message);
    }

    public String readLineFromUserInput() {
        System.out.print("> ");

        String str = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        } catch (IOException e) {
            return null;
        }

        System.out.println();

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

        if (input == null || input.isEmpty() || !input.matches("[0-9]")) return -1;

        int num = Integer.parseInt(input);

        if (!predicate.accept(num)) return -1;

        return num;
    }

    public void showIndentedMessage(Action indentedMessage) {
        indentation++;
        indentedMessage.accept();
        indentation--;
    }

    public void showFormattedMessage(String message,Object... args){
        showMessage(getFormatter().format(message,args).toString());
    }

    public void showCommandMessage(int commandNumber,String command){
        showMessage(commandNumber+" : "+command);
    }

    public void showBoxMessage(String title, String... messages) {
        int maxLength = title.length();

        for (String message : messages) {
            if (maxLength < message.length()) {
                maxLength = message.length();
            }
        }

        maxLength += 2;
        writeHorizontalLine(title, maxLength);
        StringBuilder builder;
        for (String message : messages) {
            builder = new StringBuilder();
            builder.append("| ");

            builder.append(message);

            for (int i = 0; i < (maxLength - message.length()) - 1; i++) {
                builder.append(" ");
            }

            builder.append("|");
            showMessage(builder.toString());
        }

        writeHorizontalLine("", maxLength);
    }

    public void showBoxMessage(String title, Map<String, String> messages) {
        //キモい
        final int[] maxKeyLength = {0};
        messages.entrySet().stream()
                .filter(messageEntry -> maxKeyLength[0] < messageEntry.getKey().length())
                .forEach(messageEntry -> maxKeyLength[0] = messageEntry.getKey().length());
        maxKeyLength[0] += 1;
        List<String> messageList = new ArrayList<>();
        StringBuilder builder;
        for (Map.Entry<String, String> messageEntry : messages.entrySet()) {
            builder = new StringBuilder();
            builder.append(messageEntry.getKey());
            for (int i = 0; i < (maxKeyLength[0] - messageEntry.getKey().length()); i++) {
                builder.append(" ");
            }

            builder.append(messageEntry.getValue());
            messageList.add(builder.toString());
        }

        showBoxMessage(title, messageList.toArray(new String[0]));
    }

    public void showMainCharacterStatus() {
        Map<String, String> status = new LinkedHashMap<>();
        final MainCharacter mainCharacter = GameApplication.current.getMainCharacter();

        status.put("NAME", mainCharacter.getName());
        status.put("LEVEL", mainCharacter.getLevel() + "");
        status.put("EXP", mainCharacter.getExp() + "");
        status.put("HP", mainCharacter.getStatus().getCurrentHp() + " / " + mainCharacter.getStatus().getMaxHp());
        status.put("EP", mainCharacter.getStatus().getCurrentEp() + " / " + mainCharacter.getStatus().getMaxEp());
        status.put("ATK", mainCharacter.getStatus().getAtk() + "");
        status.put("DEF", mainCharacter.getStatus().getDef() + "");

        showBoxMessage("STATUS", status);
    }

    public void showAllMap() {
        showMessage(ArtGenerater.GenerateMap(true));
    }

    public void showReachedMap(){
        showMessage(ArtGenerater.GenerateMap(false));
    }

    private void writeHorizontalLine(String title, int length) {
        StringBuilder builder = new StringBuilder();

        int first = (length - title.length()) / 2;

        for (int i = 0; i < first + 1; i++) {
            builder.append("-");
        }

        builder.append(title);

        for (int i = 0; i < (length - title.length()) - first + 1; i++) {
            builder.append("-");
        }
        showMessage(builder.toString());
    }

    private String getIndentation() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < indentation; i++) {
            builder.append("    ");
        }

        return builder.toString();
    }

    private String convertString(int i) {
        return String.valueOf(i);
    }

    public void showBar(String title, int max, int par) {
        int b = max/20;
        show(title + "[");

        for (int i = 0; i < 20; i++) {
            if (i*b<=par) {
                show("=");
                continue;
            }
            show(" ");
        }

        showMessage("]");
    }

    public void wait(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {

        }
    }
}