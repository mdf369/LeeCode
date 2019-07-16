package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FractionToRecurringDecimal {

    public String fractionToDecimal(int numerator, int denominator) {
        StringBuilder builder = new StringBuilder();
        long numeratorL = numerator;
        long denominatorL = denominator;

        boolean minus = (numeratorL >= 0 && denominatorL >= 0) || (numeratorL < 0 && denominatorL < 0);
        numeratorL = Math.abs(numeratorL);
        denominatorL = Math.abs(denominatorL);
        if (!minus && numeratorL != 0) {
            builder.append('-');
        }

        String pre = Long.toString(numeratorL / denominatorL);
        builder.append(pre);
        numeratorL = numeratorL - (numeratorL / denominatorL) * denominatorL;
        if (numeratorL == 0) {
            return builder.toString();
        }
        builder.append('.');

        Map<Long, Integer> map = new HashMap<>();
        List<Long> list = new ArrayList<>();
        while (true) {
            if (map.containsKey(numeratorL)) {
                int index = map.get(numeratorL);
                for (int i = 0; i < index; i++) {
                    builder.append(list.get(i));
                }

                builder.append('(');
                for (int i = index; i < list.size(); i++) {
                    builder.append(list.get(i));
                }
                builder.append(')');
                break;
            }

            map.put(numeratorL, list.size());
            long shang = numeratorL * 10 / denominatorL;
            numeratorL = numeratorL * 10 - denominatorL * shang;
            list.add(shang);

            if (numeratorL == 0) {
                list.forEach(num -> builder.append(num));
                break;
            }
        }
        return builder.toString();
    }
}
