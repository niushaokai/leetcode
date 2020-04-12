package medium;

import java.util.*;

/**
 * @author niushaokai
 * @date 2020/4/12
 */
public class CombinationSum40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, target, result, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int begin, int cur, List<List<Integer>> result, ArrayList<Integer> curList) {
        if (cur == 0) {
            result.add(curList);
            return;
        } else if (cur < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) continue;
            curList.add(candidates[i]);
            ArrayList<Integer> newList = (ArrayList<Integer>) curList.clone();
            helper(candidates, target, i + 1, cur - candidates[i], result, newList);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        CombinationSum40 combination = new CombinationSum40();
        List<List<Integer>> lists = combination.combinationSum2(candidates, target);
        System.out.println(lists);
    }

    /**
     * @param candidates 候选数组
     * @param len
     * @param begin      从候选数组的 begin 位置开始搜索
     * @param residue    表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
     * @param path       从根结点到叶子结点的路径
     * @param res
     */
    private void dfs(int[] candidates,
                     int len,
                     int begin,
                     int residue,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            // 大剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            // 小剪枝，这里可以去看看LeetCode题解，多体会
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);

            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs(candidates, len, i + 1, residue - candidates[i], path, res);

            path.removeLast();
        }
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);

        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }

}