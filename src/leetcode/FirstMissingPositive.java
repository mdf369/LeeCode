package leetcode;

import javafx.util.Pair;

import java.util.*;

public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        List<Pair<Integer, Integer>> list = new ArrayList<>();

        for (int num : nums){
            if (num <= 0){
                continue;
            }

            int index = search(list, num, 0, list.size());
            if (index != -1){
                list.add(index, new Pair<>(num, num));
            }
        }

        int index = -1;
        if (list.size() == 0){
            return 1;
        }
        if (list.get(0).getKey() > 1){
            return 1;
        } else {
            return list.get(0).getValue() + 1;
        }
    }

    private int search(List<Pair<Integer, Integer>> list, int target, int start, int end){
        if (start >= end){
            return start;
        }

        int middle = (start + end) / 2;
        Pair<Integer, Integer> pair = list.get(middle);
        if (pair.getKey() <= target && target <= pair.getValue()){
            return -1;
        } else if (target == pair.getKey() - 1 || target == pair.getValue() + 1){
            Pair<Integer, Integer> newPair;
            boolean combine = false;
            int shift = 0;
            if (target == pair.getKey() - 1){
                if (middle > 0 && list.get(middle - 1).getValue() == target - 1){
                    combine = true;
                    shift = -1;
                    newPair = new Pair<>(list.get(middle - 1).getKey(), pair.getValue());
                } else {
                    newPair = new Pair<>(pair.getKey() - 1, pair.getValue());
                }
            } else {
                if (middle < list.size() - 1 && list.get(middle + 1).getKey() == target + 1){
                    combine = true;
                    shift = 1;
                    newPair = new Pair<>(pair.getKey(), list.get(middle + 1).getValue());
                } else {
                    newPair = new Pair<>(pair.getKey(), pair.getValue() + 1);
                }
            }

            if (combine){
                int index = middle + shift;
                list.set(index, newPair);
                list.remove(middle);
            } else {
                list.set(middle, newPair);
            }
            return -1;
        } else if (target < pair.getKey()){
            return search(list, target, 0, middle);
        } else {
            return search(list, target, middle + 1, end);
        }
    }
}
