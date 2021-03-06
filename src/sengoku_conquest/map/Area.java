package sengoku_conquest.map;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class Area {
    private int areaNum;
    private String areaName;

    private boolean isReached = false;

    private NextAreaInfo nextAreaInfo;

    public Area(int areaNum, String areaName, NextAreaInfo nextAreaInfo) {
        this.areaNum = areaNum;
        this.areaName = areaName;
        this.nextAreaInfo = nextAreaInfo;
    }

    public int getAreaNum() {
        return areaNum;
    }

    public String getAreaName() {
        return areaName;
    }

    public NextAreaInfo getNextAreaInfo() {
        return nextAreaInfo;
    }

    public boolean isReached() {
        return isReached;
    }

    public void setReached(boolean reached) {
        isReached = reached;
    }
}
