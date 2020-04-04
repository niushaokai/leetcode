package leetcode;

/**
 * @author niushaokai
 * @date 2020/2/2
 */
public class TrailingZeroes172 {
    public int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = i;
            while (N > 0) {
                if (N % 5 == 0) {
                    count++;
                    N /= 5;
                } else {
                    break;
                }
            }
        }
        return count;

    }

    public static int trailingZeroes2(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int temp = i;
            while (temp % 5 == 0) {
                count++;
                temp /= 5;
            }
        }
        return count;
    }

    public int tailingZeroes3(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes2(6));
    }
}