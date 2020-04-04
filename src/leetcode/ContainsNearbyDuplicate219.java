package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author niushaokai
 * @date 2020/3/1
 */
public class ContainsNearbyDuplicate219 {

    //个人认为正确，但超出时间限制
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (map.containsValue(nums[i])) {
                int index = 0;
                for (Integer key : map.keySet()) {
                    if (map.get(key) == nums[i]) {
                        index = key;
                    }
                }
                int deduct = i - index;
                if (deduct <= k) {
                    return true;
                }
                map.put(i, nums[i]);
            } else {
                map.put(i, nums[i]);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 1, 1};
        System.out.println(containsNearbyDuplicate(arr, 1));
    }

    /**
     * 大神解法：
     * <p>
     * 遍历数组，对于每个元素做以下操作：
     * 在散列表中搜索当前元素，如果找到了就返回 true。
     * 在散列表中插入当前元素。
     * 如果当前散列表的大小超过了k,删除散列表中最旧的元素。
     */
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean contains(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
            if (set.size() > k)
                set.remove(nums[i - k]);
        }
        return false;
    }
}