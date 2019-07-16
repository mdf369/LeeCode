package leetcode;

import java.util.*;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int depth = nums.length;
        int[] mem = new int[depth];
        int[] used = new int[depth];

        go(res, mem, depth, 0, used, nums, 0);
        return res;
    }

    private void go(List<List<Integer>> res, int[] mem, int depth, int index, int[] used, int[] nums, int start){
        if (index > depth){
            return;
        }

        addSet(res, mem, index);

        int loc = start;
        while (true){
            while (loc < used.length && used[loc] == 1){
                loc++;
            }
            if (loc >= used.length){
                break;
            }

            used[loc] = 1;
            mem[index] = nums[loc];
            go(res, mem, depth, index + 1, used, nums, loc + 1);
            used[loc] = 0;
            loc++;
        }
    }

    private void addSet(List<List<Integer>> res, int[] mem, int depth){
        List<Integer> set = new ArrayList<>();
        for (int i = 0;i < depth;i++){
            set.add(mem[i]);
        }
        res.add(set);
    }
}
