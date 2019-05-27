package top_interview;

public class MaximumGap {

  public int maximumGap(int[] nums) {
    if (nums == null || nums.length < 2) {
      return 0;
    }

    int[] minmax = getMinAndMax(nums);

    int capacity = (minmax[1] - minmax[0]) / nums.length + 1;
    int bucketNum = (minmax[1] - minmax[0]) / capacity + 1;

    boolean[] bucketEmpty = new boolean[bucketNum];
    int[] bucketMins = new int[bucketNum];
    int[] bucketMaxs = new int[bucketNum];
    for (int i = 0; i < bucketNum; i++) {
      bucketEmpty[i] = true;
      bucketMins[i] = Integer.MAX_VALUE;
      bucketMaxs[i] = Integer.MIN_VALUE;
    }

    for (int num : nums) {
      int index = (num - minmax[0]) / capacity;
      bucketEmpty[index] = false;
      bucketMins[index] = Math.min(bucketMins[index], num);
      bucketMaxs[index] = Math.max(bucketMaxs[index], num);
    }

    int max = 0;
    int pre = bucketMaxs[0];
    for (int i = 1; i < bucketNum; i++) {
      if (bucketEmpty[i]) {
        continue;
      }
      max = Math.max(max, bucketMins[i] - pre);
      pre = bucketMaxs[i];
    }
    return max;
  }

  private int[] getMinAndMax(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    return new int[]{min, max};
  }
}
