package sengoku_conquest;

import com.sun.org.apache.xpath.internal.operations.String;

import org.omg.CORBA_2_3.portable.InputStream;

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

    public void readLineFromUserInput() throws IOException {
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        java.lang.String str = br.readLine();
        return;


    }
}