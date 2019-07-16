package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        Map<Integer, Integer> map = new HashMap<>();

        int max = 0;
        for(int i = 0;i < height.length;i++){
            int h = height[i];

            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                int th = Math.min(h, entry.getKey());
                max = Math.max(max, th * (i - entry.getValue()));
            }

            if (!map.containsKey(h)){
                map.put(h, i);
            }
        }

        return max;
    }
}
