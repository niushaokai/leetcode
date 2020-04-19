package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/4/19
 */
public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] visited = new int[nums.length];
        helper(visited, result, new ArrayList<>(), nums);
        return result;
    }

    public void helper(int[] visited, List<List<Integer>> result, List<Integer> curList, int[] nums) {
        if (curList.size() == nums.length) {
//            result.add(curList); 以前这种写法竟然一直都是错的
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            curList.add(nums[i]);
            helper(visited, result, curList, nums);
            visited[i]=0;
            curList.remove(curList.size()-1);
        }
    }

    public static void main(String[] args) {
        Permute46 permute = new Permute46();
        int[] nums = new int[]{1,2,3};
        System.out.println(permute.permute(nums));
    }

}