package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/1/26
 */
public class Permute46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1) {
            return Collections.emptyList();
        }

        // 提前计算最终结果大小，以节省列表扩张的开销
        int amount = 1;
        for (int i = nums.length; i > 1; i--) {
            amount *= i;
        }

        List<List<Integer>> result = new ArrayList<>(amount);
        result.add(new ArrayList<>(nums.length));
        result.get(0).add(nums[0]);

        // 处理到第几个元素
        for (int depth = 1; depth < nums.length; depth++) {
            int size = result.size();
            // nums数组的 depth 个元素全排列的大小
            for (int i = 0; i < size; i++) {
                // 当前result 中元素的长度为 depth-1，所以有depth个插入点
                for (int insertIdx = 0; insertIdx <= depth; insertIdx++) {
                    if (insertIdx < depth) {
                        List<Integer> tmp = new ArrayList<>(nums.length);
                        tmp.addAll(result.get(i));
                        tmp.add(insertIdx, nums[depth]);
                        result.add(tmp);
                    } else {
                        result.get(i).add(nums[depth]);
                    }
                }
            }
        }

        return result;
    }


    public static void backtrack(int n,
                                 ArrayList<Integer> nums,
                                 List<List<Integer>> output,
                                 int first) {
        // if all integers are used up
        if (first == n)
            output.add(new ArrayList(nums));
        for (int i = first; i < n; i++) {
            // place i-th integer first
            // in the current permutation
            Collections.swap(nums, first, i);
            // use next integers to complete the permutations
            backtrack(n, nums, output, first + 1);
            // backtrack
            Collections.swap(nums, first, i);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        // init output list
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums){
            nums_lst.add(num);
        }

        int n = nums.length;
        backtrack(n, nums_lst, output, 0);
        return output;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        permute2(arr);
        //swap的功能是交换list中两个位置的元素
//        ArrayList<Integer> list= new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//        list.add(7);
//        Collections.swap(list,0,1);
//        System.out.println(list);
    }
}