package sengoku_conquest.map;

/**
 * Created by C0114105 on 2016/11/18.
 */
public class NextAreaInfo {
    private int west;
    private int east;
    private int north;
    private int south;
    
    public NextAreaInfo(int west, int east, int north, int south) {
        this.west = west;
        this.east = east;
        this.north = north;
        this.south = south;
    }


    public int getWest() {
        return west;
    }

    public int getEast() {
        return east;
    }

    public int getNorth() {
        return north;
    }

    public int getSouth() {
        return south;
    }


}
