package top_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationSum {

  Map<Integer, List<List<Integer>>> map = new HashMap<>();

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if (candidates == null || candidates.length == 0) {
      return Collections.emptyList();
    }

    Arrays.sort(candidates);

    return findAllCombination(candidates, target);
  }

  private List<List<Integer>> findAllCombination(int[] candidates, int target) {
    if (map.containsKey(target)) {
      return map.get(target);
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < candidates.length; i++) {
      if (target < candidates[i]) {
        break;
      } else if (target > candidates[i]) {
        List<List<Integer>> subRes = findAllCombination(candidates, target - candidates[i]);
        for (int j = 0; j < subRes.size(); j++) {
          List<Integer> subList = subRes.get(j);
          if (subList.isEmpty() || subList.get(subList.size() - 1) < candidates[i]) {
            continue;
          }

          List<Integer> list = new ArrayList<>();
          list.addAll(subList);
          list.add(candidates[i]);
          res.add(list);
        }
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(candidates[i]);
        res.add(list);
        break;
      }
    }

    if (!res.isEmpty()) {
      map.put(target, res);
    }
    return res;
  }
}
