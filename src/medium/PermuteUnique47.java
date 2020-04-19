package medium;

import java.util.*;

/**
 * @author niushaokai
 * @date 2020/4/19
 */
public class PermuteUnique47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int[] visited = new int[nums.length];
        helper(nums, res, visited, new ArrayList<>());
        return res;

    }

    public void helper(int[] nums, List<List<Integer>> res, int[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                temp.add(nums[i]);
                helper(nums, res, visited, temp);
                temp.remove(temp.size() - 1);
                visited[i] = 0;
                //不允许同一层出现相同的数字
                while (i + 1 < nums.length && nums[i] == nums[i + 1])
                    i++;
            }

        }
    }
}