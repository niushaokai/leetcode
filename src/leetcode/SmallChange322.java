package leetcode;

import java.util.Arrays;

/**
 * 零钱兑换
 *
 * @author niushaokai
 * @date 2020-01-02
 */
public class SmallChange322 {
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        //因为不可能比amount+1还大
        int[] dp = new int[max];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    //在扫描coins数组的时候，dp[i]是在不断变化的，且dp[x]是由dp[x-?]得到的（用到了最优子结构）
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        //因为已经设置了dp中的元素都为max，如果某个元素无法组成的话，会大于amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2};
        int amount = 3;
        System.out.println(coinChange(arr, amount));
    }
}