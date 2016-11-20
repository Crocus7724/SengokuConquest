package sengoku_conquest.utilities;

import sengoku_conquest.map.Area;
import sengoku_conquest.map.NextAreaInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yamamoto on 2016/11/20.
 */
public class MappingData {
    /***
     * csvからエリア(Area)クラスを生成します
     * @return 生成されたAreaクラス配列
     */
    public static Area[] createArea() {
        final List<Area> areaList = new ArrayList<>();

        final List<String[]> areaData = CsvHelper.read("",true);

        for (String[] data : areaData) {
            String name = data[0];
            int number = Integer.parseInt(data[1]);
            int east = Integer.parseInt(data[2]);
            int west = Integer.parseInt(data[3]);
            int south = Integer.parseInt(data[4]);
            int north = Integer.parseInt(data[5]);

            Area area = new Area(number,name, new NextAreaInfo(west, east, north, south));

            areaList.add(area);
        }

        return areaList.toArray(new Area[0]);
    }
}
