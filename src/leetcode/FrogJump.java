package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FrogJump {

  private List<Integer> getReachableStoneList(int[] stones, int index, int dis) {
    List<Integer> list = new ArrayList<>();
    int min = stones[index] + dis - 1;
    int max = min + 2;
    for (int i = index + 1; i < stones.length && stones[i] <= max; i++) {
      if (stones[i] >= min) {
        list.add(i);
      }
    }
    return list;
  }

  private boolean go (int[] stones, int index, int preDis, Set<Integer>[] failSet) {
    if (index == stones.length - 1) {
      return true;
    }

    List<Integer> list = getReachableStoneList(stones, index, preDis);
    for (Integer i : list) {
      if (failSet[index].contains(i)) {
        continue;
      }

      if (go(stones, i, stones[i] - stones[index], failSet)) {
        return true;
      } else {
        failSet[index].add(i);
      }
    }
    return false;
  }

  public boolean canCross(int[] stones) {
    if (stones[1] != 1) {
      return false;
    }

    Set<Integer>[] failSet = new Set[stones.length];
    for (int i = 0; i < failSet.length; i++) {
      failSet[i] = new HashSet<>();
    }

    return go(stones, 1, 1, failSet);
  }
}
