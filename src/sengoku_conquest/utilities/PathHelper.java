package sengoku_conquest.utilities;

import java.nio.file.Paths;

/**
 * Created by Yamamoto on 2016/11/20.
 */
public class PathHelper {
    public static final String currentPath=System.getProperty("user.dir");



    private String getConstFolderPath(final String fileName){
        return Paths.get("src","sengoku_conquest","const_values",fileName).toString();
    }
}
