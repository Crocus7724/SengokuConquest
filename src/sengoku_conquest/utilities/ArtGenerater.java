package sengoku_conquest.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import sengoku_conquest.GameApplication;
import sengoku_conquest.character.EnemyCharacter;
import sengoku_conquest.const_values.Consts;
import sengoku_conquest.const_values.Strings;
import sengoku_conquest.map.Area;
import sengoku_conquest.map.EnemyArea;
import sengoku_conquest.map.ItemArea;

/**
 * Created by Yamamoto on 2016/12/04.
 * 闇が深いクラス
 */
public class ArtGenerater {
    public static String GenerateMap(boolean isAll) {
        return new MapCreater().create(isAll);
    }
}

class MapCreater {
    private List<Place> areaMap = new ArrayList<>();

    MapCreater() {
        final Map<Integer, Area> map = GameApplication.current.getMap();
        areaMap.add(new Place(1, 7, map.get(1)));
        areaMap.add(new Place(2, 7, map.get(2)));
        areaMap.add(new Place(3, 7, map.get(3)));
        areaMap.add(new Place(4, 7, map.get(4)));
        areaMap.add(new Place(2, 6, map.get(5)));
        areaMap.add(new Place(3, 6, map.get(6)));
        areaMap.add(new Place(5, 7, map.get(7)));
        areaMap.add(new Place(4, 6, map.get(8)));
        areaMap.add(new Place(5, 6, map.get(9)));
        areaMap.add(new Place(6, 6, map.get(10)));
        areaMap.add(new Place(5, 5, map.get(11)));
        areaMap.add(new Place(3, 5, map.get(12)));
        areaMap.add(new Place(4, 5, map.get(13)));
        areaMap.add(new Place(3, 4, map.get(14)));
        areaMap.add(new Place(4, 4, map.get(15)));
        areaMap.add(new Place(5, 4, map.get(16)));
        areaMap.add(new Place(6, 4, map.get(17)));
        areaMap.add(new Place(3, 3, map.get(18)));
        areaMap.add(new Place(4, 3, map.get(19)));
        areaMap.add(new Place(3, 2, map.get(20)));
        areaMap.add(new Place(4, 2, map.get(21)));
        areaMap.add(new Place(5, 3, map.get(22)));
        areaMap.add(new Place(5, 2, map.get(23)));
        areaMap.add(new Place(3, 1, map.get(24)));
        areaMap.add(new Place(4, 1, map.get(25)));
    }

    public String create(boolean isAll) {
        // まとめ用StringBuilder
        final StringBuilder all = new StringBuilder();
        for (int i = 0; i < Consts.MAP_MAX_VERTICAL; i++) {
            StringBuilder[] box = {new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder(), new StringBuilder()};

            // Why Java!!!
            int finalI = i + 1;
            final List<Place> verticals = areaMap.stream().filter(x -> x.vertical == finalI).collect(Collectors.toList());

            for (int j = 0; j < Consts.MAP_MAX_WIDTH; j++) {
                int finalJ = j + 1;
                final Optional<Place> optionalPlace = verticals.stream().filter(x -> x.width == finalJ).findFirst();

                if (optionalPlace.isPresent()) {
                    final Area area = optionalPlace.get().area;
                    if (isAll || area.isReached()) {
                        box[0].append(createHeader(area));
                        box[1].append(createSeconds(area));
                        box[2].append(createMiddle(area));
                        box[3].append(createFourth(area));
                        box[4].append(createFooter(area));
                    } else {
                        for (StringBuilder builder : box) builder.append(createBlank());
                    }
                } else {
                    for (StringBuilder builder : box) {
                        builder.append(createBlank());
                    }
                }
            }

            Arrays.stream(box)
                    .map(StringBuilder::toString)
                    .filter(x -> !x.matches("^ *$"))
                    .forEach(x -> all.append(x).append("\n"));
        }

        return all.toString();
    }

    private String createHeader(Area area) {
        StringBuilder builder = new StringBuilder();
        builder.append("===");
        if (area.getNextAreaInfo().getNorth() != -1) {
            builder.append("   ");
        } else {
            builder.append("===");
        }

        builder.append("===");

        return builder.toString();
    }

    private String createSeconds(Area area) {
        StringBuilder builder = new StringBuilder();
        builder.append("|   ");

        // 敵キャラがいるならその強さ、アイテムなら△
        if (area instanceof EnemyArea) {
            EnemyCharacter enemy = ((EnemyArea) area).getEnemy();
            if (enemy.getStatus().getCurrentHp() > 0) {
                switch (enemy.getLevel()) {
                    case 1:
                        builder.append("C");
                        break;
                    case 2:
                        builder.append("B");
                        break;
                    case 3:
                        builder.append("A");
                        break;
                    case 4:
                        builder.append("S");
                        break;
                }
            } else {
                builder.append(" ");
            }
        } else if (area instanceof ItemArea) {
            final ItemArea itemArea = (ItemArea) area;
            if (!itemArea.isFind()) {
                builder.append("△");
            } else {
                builder.append(" ");
            }
        } else {
            builder.append(" ");
        }

        builder.append("   |");

        return builder.toString();
    }

    private String createMiddle(Area area) {
        StringBuilder builder = new StringBuilder();

        // 西に進めたら空白
        if (area.getNextAreaInfo().getWest() != -1) {
            builder.append(Strings.ANVISIBLE_CHARACTER + "   ");
        } else {
            builder.append("|   ");
        }

        // プレイヤーがいたらP
        if (GameApplication.current.getCurrentArea().getAreaNum() == area.getAreaNum()) {
            builder.append("P");
        } else {
            builder.append(" ");
        }

        // 東に進めたら空白
        if (area.getNextAreaInfo().getEast() != -1) {
            builder.append(Strings.ANVISIBLE_CHARACTER + "   ");
        } else {
            builder.append("   |");
        }

        return builder.toString();
    }

    private String createFourth(Area area) {
        return "|       |";
    }

    private String createFooter(Area area) {
        StringBuilder builder = new StringBuilder();
        builder.append("===");

        if (area.getNextAreaInfo().getSouth() != -1) {
            builder.append("   ");
        } else {
            builder.append("===");
        }

        builder.append("===");

        return builder.toString();
    }

    private String createBlank() {
        return "         ";
    }
}

class Place {
    public final int vertical;
    public final int width;
    public final Area area;

    Place(int vertical, int width, Area area) {
        this.vertical = vertical;
        this.width = width;
        this.area = area;
    }

}

