package leetcode;

/**
 * @author niushaokai
 * @date 2020/2/29
 */
public class Rob198 {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0)
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[len];
    }

    public int shen(int[] nums) {
        int first = 0;
        int second = 0;
        for (int i : nums) {
            int temp = second;
            second = Math.max(second, first + i);
            first = temp;
        }
        return second;
    }

    /**
     * qinchao method1
     * dp[i][]:0...i能偷到的最大值，第二个维度1:stole,0:not stole
     */
    public int rob1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //1:stole,0:not stole
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        dp[0][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            //之前的可以偷，也可以不偷
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            //之前的不可以偷，本房子必须偷
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    /**
     * qinchao method2
     * dp[i]:0...i，且nums[i]必须偷的最大值 最后的结果是Max(dp)，因为肯定要某天必须偷才能取得最大值，所以遍历dp拿到最大值即可
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //因为后面用到了nums[1]，所以要单独判断一下数组长度等于1的情况
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /**
     * qinchao method3
     * 因为我看看到method2中用到了前一个和再前一个变量，类似于斐波那契数列，所以我们不需要开辟数组，只需要定义3个变量就够了
     */
    public int rob3(int[] nums) {
        int preMax = 0, curMax = 0;
        for (int item : nums) {
            int temp = curMax;
            curMax = Math.max(preMax + item, curMax);
            preMax = temp;
        }
        return curMax;
    }
}