package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/13
 */
public class UniquePaths62 {
    public static int uniquePaths(int m, int n) {
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            arr[0][j] = 1;
        }

        for (int a = 1; a < m; a++) {
            for (int b = 1; b < n; b++) {
                arr[a][b] = arr[a - 1][b] + arr[a][b - 1];
            }
        }
        return arr[m - 1][n - 1];

    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(2, 1));
    }
}