package sengoku_conquest.map;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class Area {
    int Areanum=17;
    String Areaname="start";
    NextAreaInfo nextAreaInfo;

    public Area(int areanum, String areaname, NextAreaInfo nextAreaInfo) {
        Areanum = areanum;
        Areaname = areaname;
        this.nextAreaInfo = nextAreaInfo;
    }
}
