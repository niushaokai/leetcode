package leetcode;

import java.util.Arrays;

/**
 * @author niushaokai
 * @date 2020-01-02
 */
public class LengthOfLIS300 {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int x = 0; x < dp.length; x++) {
            res = Math.max(res, dp[x]);
        }
        return res;
    }
}