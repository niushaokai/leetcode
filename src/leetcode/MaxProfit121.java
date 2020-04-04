package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/14
 */
public class MaxProfit121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            if (prices[i] - minPrice > maxPrice) {
                maxPrice = prices[i] - minPrice;
            }
        }
        return maxPrice;
    }

    //write by my own
    public static int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        //第二个维度代表是否持有0：无，1：有，第三个维度代表是否交易过(sell)0：无，1：有
        int dp[][][] = new int[prices.length][2][2];
        dp[0][0][0] = 0;
        dp[0][1][0] = 0 - prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0];
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            dp[i][1][0] = Math.max(dp[i - 1][0][0] - prices[i], dp[i - 1][1][0]);
        }
        //最大值一定是不持有且卖出的
        return dp[prices.length - 1][0][1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        maxProfit2(arr);
    }
}