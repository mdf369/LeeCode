package top_interview;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountOfSmallerNumbersAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null) {
            return null;
        }

        List<Integer> res = new ArrayList<>();
        Map<Integer, Pair<Integer, Integer>> mem = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            if (mem.containsKey(n)) {
                Pair<Integer, Integer> pair = mem.get(n);

                int count = pair.getValue() + searchSmaller(nums, i + 1, pair.getKey(), nums[i]);
                mem.put(n, new Pair<>(i, count));
                res.add(0, count);
            } else {
                int count = searchSmaller(nums, i + 1, nums.length, nums[i]);
                mem.put(n, new Pair<>(i, count));
                res.add(0, count);
            }
        }
        return res;
    }

    private int searchSmaller(int[] nums, int start, int end, int target) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (target > nums[i]) {
                count++;
            }
        }
        return count;
    }
}
