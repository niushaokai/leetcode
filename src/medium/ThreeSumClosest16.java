package medium;

import java.util.Arrays;

/**
 * @author niushaokai
 * @date 2020/3/23
 */
public class ThreeSumClosest16 {
    //自己写的错误代码
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        //别人答案使用了双指针，在for循环中使用while循环，先试试自己的这种写法有什么问题
        //自己的代码问题在于：和target最接近的3个数字不一定是连续的，不要先入为主！！！
        for (int i = 1; i < nums.length - 2; i++) {
            if (nums[i] * 3 > target) {
                return (nums[i] + nums[i + 1] + nums[i + 2] - target) < diff ? (nums[i] + nums[i + 1] + nums[i + 2]) : closest;
            } else {
                int temp = nums[i] + nums[i + 1] + nums[i + 2];
                int newAbs = Math.abs(temp - target);
                if (newAbs < diff) {
                    closest = temp;
                    diff = newAbs;
                }
            }
        }
        return closest;
    }

    //大神代码，排序+双指针
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if (sum > target)
                    end--;
                else if (sum < target)
                    start++;
                else
                    return ans;
            }
        }
        return ans;
    }


    public int threeSumClosest3(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int temp = nums[i] + nums[start] + nums[end];
                if (Math.abs(temp - target) < Math.abs(ans - target)) {
                    ans = temp;
                }
                if (temp < target) {
                    start++;
                } else if (temp > target) {
                    end--;
                } else {
                    return ans;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ThreeSumClosest16 threeSome = new ThreeSumClosest16();
        int[] nums = new int[]{0, 2, 1, -3};
        System.out.println(threeSome.threeSumClosest3(nums, 1));
    }
}