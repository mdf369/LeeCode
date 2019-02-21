package top_interview;

import java.util.HashMap;
import java.util.Map;

public class PerfectSquares {

    private Map<Integer, Integer> map = new HashMap<>();

    public int numSquares(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        if (n == 0) {
            return 0;
        }

        int factor = (int) Math.sqrt(n);
        int minCount = Integer.MAX_VALUE;
        while (factor > 0) {
            minCount = Math.min(minCount, numSquares(n - factor * factor));
            factor--;
        }
        minCount++;
        map.put(n, minCount);
        return minCount;
    }
}
