package easy;

/**
 * @author niushaokai
 * @date 2020/3/20
 */
public class MinCostClimbingStairs746 {
    public int minCostClimbingStairs(int[] cost) {
        int[][] dp = new int[cost.length][2];
        dp[0][0] = 0;
        dp[0][1] = cost[0];
        for (int i = 1; i < cost.length; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = Math.min(dp[i - 1][1], dp[i - 1][0]) + cost[i];
        }
        return Math.min(dp[cost.length-1][0],dp[cost.length-1][1]);
    }
}