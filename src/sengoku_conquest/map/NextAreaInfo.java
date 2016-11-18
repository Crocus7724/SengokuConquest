package sengoku_conquest.map;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class NextAreaInfo {
    public NextAreaInfo(int west, int east, int north, int south) {
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
    }

    int west;
    int east;
    int north;
    int south;
}
