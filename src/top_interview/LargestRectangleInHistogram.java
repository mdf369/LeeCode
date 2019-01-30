package top_interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0){
            return 0;
        }

        Map<Integer, Integer> locMap = new HashMap<>();
        int maxArea = 0;

        for (int i = 0;i < heights.length;i++){
            updateLocMap(locMap, heights[i], i);
            maxArea = Math.max(maxArea, getMaxArea(locMap, heights[i], i));
        }
        return maxArea;
    }

    private void updateLocMap(Map<Integer, Integer> locMap, int height, int index){
        int min = index;
        Set<Integer> toRemove = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : locMap.entrySet()) {
            if (entry.getKey() >= height){
                min = Math.min(min, entry.getValue());
                toRemove.add(entry.getKey());
            }
        }
        toRemove.forEach(n -> locMap.remove(n));
        locMap.put(height, min);
    }

    private int getMaxArea(Map<Integer, Integer> locMap, int height, int index){
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : locMap.entrySet()) {
            int area = Math.min(height, entry.getKey()) * (index - entry.getValue() + 1);
            max = Math.max(max, area);
        }
        return max;
    }
}
