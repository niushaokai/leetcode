package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/15
 */
public class MinDistance72 {
    /**
     * 因为题意要求从word1到word2，word是可变的，word2是不可变的。dp[i-1][j] 表示当前word1[i]与word2[j]是不匹配的，
     * 那我去找下word1[i-1]与word2[j]匹配的情况，如果该情况下最小，那就删除当前的word1[i]。
     * dp[i][j-1]表示我去看看word1[i]与word2[j-1]的匹配情况，如果匹配的结果是最小的，那就增加一个word1[i+1] == word2[j]就行了。
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = j;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = i;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }

    public static void main(String[] args) {
        Long a = 1000l;
        Long b = 1000l;
        System.out.println(a.longValue() == b.longValue());
    }
}