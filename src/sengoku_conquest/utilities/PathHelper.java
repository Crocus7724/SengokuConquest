package sengoku_conquest.utilities;

import java.nio.file.Paths;

/**
 * Created by Yamamoto on 2016/11/20.
 */
public class PathHelper {
    public static final String currentPath=System.getProperty("user.dir");

    public static final String mapsPath=getConstFolderPath("maps.csv");

    private static String getConstFolderPath(final String fileName){
        return Paths.get(currentPath,"src","sengoku_conquest","const_values",fileName).toString();
    }
}
