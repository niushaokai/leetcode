package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/16
 */
public class NumTrees96 {

    public int numTrees(int n) {
        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }
        return arr[n];
    }


    //官方题解
    public int numTrees2(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}