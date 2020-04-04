package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/31
 */
public class Divide29 {
    //我的解法，会超时
    public static int divide(int dividend, int divisor) {
        boolean positive;
        if (dividend <= 0 && divisor > 0) {
            positive = false;
        } else if (dividend >= 0 && divisor < 0) {
            positive = false;
        } else {
            positive = true;
        }
        int count = 0;
        if (Math.abs(dividend) == Integer.MIN_VALUE) {
            dividend = Integer.MAX_VALUE;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            dividend -= divisor;
            count++;
        }
        if (positive) {
            return count;
        } else {
            return 0 - count;
        }
    }

    public static void main(String[] args) {
        int a = 187;
        int b = 2;
        System.out.println(divide2(a, b));
    }

    public static int divide2(int dividend, int divisor) {
        boolean sign = (dividend > 0) ^ (divisor > 0);
        int result = 0;
        if (dividend > 0) {
            dividend = -dividend;
        }
        if (divisor > 0) divisor = -divisor;
        while (dividend <= divisor) {
            int temp_result = -1;
            int temp_divisor = divisor;
            while (dividend <= (temp_divisor << 1)) {
                if (temp_divisor <= (Integer.MIN_VALUE >> 1)) break;
                temp_result = temp_result << 1;
                temp_divisor = temp_divisor << 1;
            }
            dividend = dividend - temp_divisor;
            result += temp_result;
        }
        if (!sign) {
            if (result <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            result = -result;
        }
        return result;
    }
}