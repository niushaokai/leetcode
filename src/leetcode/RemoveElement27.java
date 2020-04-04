package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/5
 */
public class RemoveElement27 {

    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i]!=val){
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,2,3};
        int target = 3;
        System.out.println(removeElement(arr,target));
    }
}