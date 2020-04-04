package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/7
 */
public class MaxSubArray53 {

    /**
     * 方法：动态规划(用参数nums作为dp数组，不申请额外空间)
     * 两种情况：
     * 1.当前元素为子序起始点
     * 2.当前元素为子序中间或结尾点
     * so：nums[i] = nums[i]和nums[i] + nums[i -1]（第二种情况）中的最大值
     * */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}