package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> rest = new ArrayList<>();
        for (int num : nums) {
            rest.add(num);
        }

        go(res, new ArrayList<>(), rest);
        return res;
    }

    private void go(List<List<Integer>> res, List<Integer> candidate, List<Integer> rest){
        if (rest.size() == 0){
            res.add(candidate);
            return;
        }

        for (int n : rest){
            List<Integer> newCandidate = new ArrayList<>(candidate);
            List<Integer> newRest = new ArrayList<>(rest);

            newCandidate.add(n);
            newRest.remove((Integer) n);

            go(res, newCandidate, newRest);
        }
    }
}
