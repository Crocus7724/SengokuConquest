package sengoku_conquest.utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/20.
 */
public class CsvHelper {
    /***
     * csvファイルを読み込みます
     * @param path 読み込むcsvファイルのパス
     * @return カンマ(, )区切りの文字列を分割したものを列ごとにまとめたもの
     */
    public static List<String[]> read(final String path,final boolean hasHeader) {
        List<String[]> lines = new ArrayList<>();
        BufferedReader br = null;
        FileReader fr = null;

        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);

            String line;
            if(hasHeader)br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.isEmpty()) continue;

                lines.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return lines;
    }
}
