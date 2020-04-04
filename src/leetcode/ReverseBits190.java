package leetcode;

/**
 * @author niushaokai
 * @date 2020/2/29
 */
public class ReverseBits190 {

    public int reverseBits(int n) {
        int ans = 0;
        for (int bitsSize = 31; n != 0; n = n >>> 1, bitsSize--) {
            //取最后一位，左移相应位数
            ans += (n & 1) << bitsSize;
        }
        return ans;
    }
}