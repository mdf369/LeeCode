package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SlidingWindowMedian {

  private void add(List<Integer> list, int v) {
    int index = 0;
    while (index < list.size() && list.get(index) < v) {
      index++;
    }
    list.add(index, v);
  }

  private void remove(List<Integer> list, int v) {
    int index = 0;
    while (index < list.size() && list.get(index) != v) {
      index++;
    }
    list.remove(index);
  }

  public double[] medianSlidingWindow(int[] nums, int k) {
    List<Integer> cache = new ArrayList<>(k);

    for (int i = 0; i < k; i++) {
      cache.add(nums[i]);
    }
    Collections.sort(cache);
    boolean odd = (k & 1) == 1;

    double[] res = new double[nums.length - k + 1];
    for (int i = 0; i < res.length; i++) {
      if (i > 0) {
        int deleteV = nums[i - 1];
        remove(cache, deleteV);

        int addV = nums[i + k - 1];
        add(cache, addV);
      }

      int middle = k / 2;
      res[i] = odd ? cache.get(middle) : (cache.get(middle) + (long) cache.get(middle - 1)) / 2.0;
    }

    return res;
  }
}
