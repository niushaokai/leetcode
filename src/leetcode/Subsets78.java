package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/2/27
 */
public class Subsets78 {
    //逐个枚举，空集的幂集只有空集，每增加一个元素，让之前幂集中的每个集合，追加这个元素，就是新增的子集。

    /**
     * 循环枚举
     */
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    /**
     * 递归枚举
     */
    public static void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<Integer>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        recursion(nums, i + 1, res);
    }


    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        int[] nums = new int[]{1, 2, 3};
        recursion(nums, 0, res);
        System.out.println(res);
    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    //递归实现
    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    //qinchao method
    private void dfs(List<List<Integer>> ans, int[] nums, List<Integer> list, int index) {
        //terminator
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        dfs(ans, nums, list, index + 1); // not pick the number at this index
        list.add(nums[index]);
        dfs(ans, nums, list, index + 1); //pick the number at this index

        //reverse the current state,因为list作为参数，在本层递归的改变会影响上层的调用，所以需要恢复成传入的状态
        list.remove(list.size() - 1);
    }
}