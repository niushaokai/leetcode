package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/3/23
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        //因为排序了，所以不会出现重复的满足条件的组合
        Arrays.sort(nums);
        int length = nums.length;
        for (int k = 0; k < length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int target = 0 - nums[k], i = k + 1, j = length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    ArrayList list = new ArrayList();
                    list.add(nums[k]);
                    list.add(nums[i]);
                    list.add(nums[j]);
                    result.add(list);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++ ;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    //这个一定不要忘了，否则一直死循环
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum15 threeSome = new ThreeSum15();
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSome.threeSum(nums));
    }
}