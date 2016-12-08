package sengoku_conquest.utilities;

import java.util.Random;

/**
 * Created by Yamamoto on 2016/11/25.
 */
public class DamageCalcurator {
    private static Random r = new Random();

    public static int calc(int attack, int def) {
        final int n = r.nextInt(3) - 1;

        return (attack - def + n);
    }
}
