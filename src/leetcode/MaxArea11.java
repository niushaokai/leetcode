package leetcode;

/**
 * @author niushaokai
 * @date 2020-01-03
 */
public class MaxArea11 {

    public int maxArea(int[] height) {

        int res = 0, left = 0;
        int right = height.length - 1;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;

    }

    //暴力法
    public int maxArea2(int[] height) {
        int max = 0;
        //注意这里i，j的起始范围
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max((j - 1) * Math.min(height[i], height[j]), max);
            }
        }
        return max;
    }

    //双指针，为什么人家代码就能写得这么漂亮！！！
    public int maxArea3(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            int minHeight = height[i] < height[j] ? height[i++] : height[j--];
            //因为上面i++或者j--有一个要执行，所以下面j-i之后要+1
            int area = (j - i + 1) * minHeight;
            max = Math.max(max, area);
        }
        return max;
    }
}