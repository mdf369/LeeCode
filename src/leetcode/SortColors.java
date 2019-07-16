package leetcode;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] mem = new int[3];

        for (int num : nums){
            mem[num]++;
        }

        int c = 0;
        for (int i = 0;i < nums.length;i++){
            while (mem[c] <= 0){
                c++;
            }

            mem[c]--;
            nums[i] = c;
        }
    }
}
