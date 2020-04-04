package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/7
 */
public class HammingWeight191 {


    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }


    /**
     * >>：带符号右移。正数右移高位补0，负数右移高位补1。比如：
     *
     * 4 >> 1，结果是2；-4 >> 1，结果是-2。-2 >> 1，结果是-1。
     *
     * >>>：无符号右移。无论是正数还是负数，高位通通补0。
     *
     * 对于正数而言，>>和>>>没区别。
     * */
    public static void main(String[] args) {
        int x = -10;
        int a = x >>> 1;
        int b = x >> 1;
        System.out.println(a);
        System.out.println(b);
    }
}