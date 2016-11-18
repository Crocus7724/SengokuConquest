package sengoku_conquest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by C0114544 on 2016/11/18.
 */

public class GameEngine {


    public void showMessage(String message) {
        System.out.println(message);
    }

    public String readLineFromUserInput()  {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        String str = null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            return null;
        }

        return str;
    }
}