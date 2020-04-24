package medium;

/**
 * @author niushaokai
 * @date 2020/4/23
 */
public class SubarraySum560 {
    public int subarraySum(int[] nums, int k) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                arr[i] += nums[j];
            }
        }
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (arr[i] == k) count++;
            for (int j = 0; j < i; j++) {
                if (i != j) {
                    int deduct = arr[i] - arr[j];
                    if (deduct == k) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        SubarraySum560 sub = new SubarraySum560();
        System.out.println(sub.subarraySum(nums, 0));
    }
}