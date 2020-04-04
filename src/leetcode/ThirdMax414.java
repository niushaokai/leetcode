package leetcode;

import java.util.*;

/**
 * @author niushaokai
 * @date 2020/1/8
 */
public class ThirdMax414 {
    public static int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int len = 1;
        if (nums.length < 3) {
            return nums[nums.length - 1];
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            //注意：这里是不等于
            if (nums[i] != nums[i + 1]) {
                len++;
            }
            if (len == 3) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }


    /**
     * 借助红黑树
     * 维护一个只有3个元素的TreeSet，如果大于三个元素就就把Set中的最小最小值remove掉。
     * 最后如果Set中元素小于3就返回Set最大值，否则返回最小值。
     */
    public int thirdMax2(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new RuntimeException("error");
        }

        //默认是小顶堆
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer elem : nums) {
            set.add(elem);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        // set.last() 里面最大的元素
        return set.size() < 3 ? set.last() : set.first();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }
}