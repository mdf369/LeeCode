package leetcode;

import javafx.util.Pair;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<Pair<Integer, Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0;i < nums.length;i++){
            for(int j = i + 1;j < nums.length;j++){
                Pair<Integer, Integer> pair = new Pair<>(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j]));
                if (set.contains(pair)){
                    continue;
                }

                int target = 0 - nums[i] - nums[j];

                for(int k = j + 1;k < nums.length;k++){
                    if (nums[k] == target){
                        List<Integer> subRes = new ArrayList<>();
                        subRes.add(nums[i]);
                        subRes.add(nums[j]);
                        subRes.add(nums[k]);
                        Collections.sort(subRes);
                        res.add(subRes);

                        set.add(new Pair<>(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j])));
                        set.add(new Pair<>(Math.min(nums[i], nums[k]), Math.max(nums[i], nums[k])));
                        set.add(new Pair<>(Math.min(nums[k], nums[j]), Math.max(nums[k], nums[j])));

                        break;
                    }
                }
            }
        }

        return res;
    }
}
