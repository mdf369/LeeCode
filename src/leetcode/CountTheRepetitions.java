package leetcode;

public class CountTheRepetitions {

  private int[] getZheng(String s1, String s2) {
    int index1 = 0;
    int index2 = 0;
    int count1 = 0;
    int count2 = 0;
    while (true) {
      if (index2 >= s2.length()) {
        index2 = 0;
        count2++;
      }

      if (index1 >= s1.length()) {
        index1 = 0;
        count1++;
        if (index2 == 0) {
          if (count2 == 0) {
            return null;
          } else {
            return new int[]{count1, count2};
          }
        }
      }

      while (index1 < s1.length() && index2 < s2.length()) {
        while (index1 < s1.length() && s1.charAt(index1) != s2.charAt(index2)) {
          index1++;
        }
        if (index1 >= s1.length()) {
          break;
        }

        index1++;
        index2++;
      }
    }
  }

  public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
    int[] zheng = getZheng(s1, s2);
    int max2 = (int) (n1 * (zheng[1] / (double) zheng[0]));
    return max2 / n2;
  }
}
