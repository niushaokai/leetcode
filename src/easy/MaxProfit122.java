package easy;

/**
 * @author niushaokai
 * @date 2020/4/14
 */
public class MaxProfit122 {
    public int maxProfit(int[] prices) {
        //第i天持有/不持有的最大收益
        int[][] dp = new int[prices.length][2];
        //1 hold,0 do not hold
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }

    public static void main(String[] args) {
        MaxProfit122 maxProfit = new MaxProfit122();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit.maxProfit(prices));
    }
}