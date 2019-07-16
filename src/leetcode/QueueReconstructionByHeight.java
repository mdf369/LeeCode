package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {

  public int[][] reconstructQueue(int[][] people) {
    if (people == null) {
      return null;
    }

    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        if (o1[0] == o2[0]) {
          return o1[1] - o2[1];
        } else {
          return o1[0] - o2[0];
        }
      }
    });

    int preLen = -1;
    for (int i = people.length - 1; i >= 0; i--) {
      if (preLen < 0) {
        preLen = getPreLen(people, i);
      }

      if (preLen < people[i][1]) {
        moveBack(people, i, people[i][1] - preLen);
      }
      preLen--;
    }
    return people;
  }

  private void moveBack(int[][] people, int index, int dis) {
    int[] temp = people[index];
    for (int i = 0; i < dis; i++) {
      people[index + i] = people[index + i + 1];
    }
    people[index + dis] = temp;
  }

  private int getPreLen(int[][] people, int start) {
    int h = people[start][0];
    int index = start - 1;
    while (index >= 0 && people[index][0] == h) {
      index--;
    }
    return start - index - 1;
  }
}
