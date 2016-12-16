package sengoku_conquest.utilities;

import java.io.*;
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
    public static List<String[]> read(final String path, final boolean hasHeader) {
        List<String[]> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))) {
            String line;
            if (hasHeader) br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || line.isEmpty()) continue;

                lines.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
