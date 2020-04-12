package medium;

import java.util.*;

/**
 * @author niushaokai
 * @date 2020/4/8
 */

public class Combine39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = candidates.length;

        // 排序是为了提前终止搜索
        Arrays.sort(candidates);

        dfs(candidates, len, target, 0, new ArrayDeque<>(), res);
        return res;
    }

    /**
     * @param candidates 数组输入
     * @param len        输入数组的长度，冗余变量
     * @param residue    剩余数值
     * @param begin      本轮搜索的起点下标
     * @param path       从根结点到任意结点的路径
     * @param res        结果集变量
     */
    private void dfs(int[] candidates,
                     int len,
                     int residue,
                     int begin,
                     Deque<Integer> path,
                     List<List<Integer>> res) {
        if (residue == 0) {
            // 由于 path 全局只使用一份，到叶子结点的时候需要做一个拷贝
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {

            // 在数组有序的前提下，剪枝
            if (residue - candidates[i] < 0) {
                break;
            }

            path.addLast(candidates[i]);
            dfs(candidates, len, residue - candidates[i], i, path, res);
            path.removeLast();

        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), target, result);
        return result;
    }

    public void helper(int[] arr, int target, int begin, ArrayList<Integer> curList, int cur, List<List<Integer>> result) {
        if (cur == 0) {
            result.add(curList);
            return;
        } else if (cur < 0) {
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            curList.add(arr[i]);
            ArrayList<Integer> newList = (ArrayList<Integer>) curList.clone();
            //注意新的begin位置不能是i+1
            helper(arr, target, i, newList, cur - arr[i], result);
            curList.remove(curList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        Combine39 combine = new Combine39();
        List<List<Integer>> lists = combine.combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
