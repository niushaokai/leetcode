package easy;

/**
 * @author niushaokai
 * @date 2020/4/4
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //这里有可能做的操作是自己=自己
                nums[insertPos] = nums[i];
                if (insertPos != i) {
                    nums[i] = 0;
                }
                insertPos++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!=0){
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        while (insertPos<nums.length){
            nums[insertPos++] = 0;
        }
    }
}