package acmcoder;

import java.util.Scanner;

public class FlipArray {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = Integer.parseInt(scanner.nextLine());
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = scanner.nextInt();
    }
    scanner.close();

    if (n <= 1) {
      System.out.println("yes");
      return;
    }

    int index = getDescStart(nums);
    if (index == -1) {
      System.out.println("yes");
    } else {
      int left = index;
      while (index < n - 1 && nums[index] > nums[index + 1]) {
        index++;
      }
      int right = index;

      if (left > 0 && nums[right] < nums[left - 1]) {
        System.out.println("no");
        return;
      }
      if (right < n - 1 && nums[left] > nums[right + 1]) {
        System.out.println("no");
        return;
      }

      boolean flag = true;
      while (index < n - 1) {
        if (nums[index] > nums[index + 1]) {
          flag = false;
          break;
        }
        index++;
      }
      if (flag) {
        System.out.println("yes");
      } else {
        System.out.println("no");
      }
    }
  }

  private static int getDescStart(int[] nums) {
    int index = -1;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        index = i;
        break;
      }
    }
    return index;
  }
}
