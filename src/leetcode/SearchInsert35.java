package leetcode;

/**
 * @author niushaokai
 * @date 2020-01-02
 */
public class SearchInsert35 {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        if (nums[nums.length-1]<target){
            return nums.length;
        }
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        // 注意：一定得返回左边界 left，
        // 如果返回右边界 right 提交代码不会通过
        // 【注意】下面我尝试说明一下理由，如果你不太理解下面我说的，那是我表达的问题
        // 但我建议你不要纠结这个问题，因为我将要介绍的二分查找法模板，可以避免对返回 left 和 right 的讨论

        // 理由是对于 [1,3,5,6]，target = 2，返回大于等于 target 的第 1 个数的索引，此时应该返回 1
        // 在上面的 while (left <= right) 退出循环以后，right < left，right = 0 ，left = 1
        // 根据题意应该返回 left，
        // 如果题目要求你返回小于等于 target 的所有数里最大的那个索引值，应该返回 right
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(arr,target));
    }
}