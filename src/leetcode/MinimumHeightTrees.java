package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    Set<Integer>[] edgeMatrix = new Set[n];
    for (int i = 0; i < n; i++) {
      edgeMatrix[i] = new HashSet<>();
    }
    for (int[] edge : edges) {
      int x = edge[0];
      int y = edge[1];
      edgeMatrix[x].add(y);
      edgeMatrix[y].add(x);
    }

    Set<Integer> nodeSet = new HashSet<>();
    for (int i = 0; i < n; i++) {
      nodeSet.add(i);
    }
    while (nodeSet.size() > 2) {
      Set<Integer> outsiders = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if (!nodeSet.contains(i)) {
          continue;
        }

        if (edgeMatrix[i].size() == 1) {
          outsiders.add(i);
        }
      }

      for (int i = 0; i < n; i++) {
        edgeMatrix[i].removeAll(outsiders);
      }
      nodeSet.removeAll(outsiders);
    }

    return new ArrayList<>(nodeSet);
  }
}
