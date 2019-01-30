package top_interview;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int[] mem = new int[nums.length];

        return jump(nums, 0, mem);
    }

    private boolean jump(int[] nums, int index, int[] mem){
        if (index >= nums.length){
            return false;
        } else if (index == nums.length - 1){
            return true;
        }
        if (mem[index] == -1){
            return false;
        } else if (mem[index] == 1){
            return true;
        }

        for (int i = 1;i <= nums[index];i++){
            if (index + i < nums.length && jump(nums, index + i, mem)){
                mem[index + i] = 1;
                return true;
            } else {
                if (index + i < nums.length){
                    mem[index + i] = -1;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
