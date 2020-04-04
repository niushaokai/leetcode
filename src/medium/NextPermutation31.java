package medium;

/**
 * @author niushaokai
 * @date 2020/3/30
 */
public class NextPermutation31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        //从尾向前找，找到第一组前面大于后面的
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            //从尾向前找，找到第一个比nums[i]大的数字nums[j]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        //将i之后的数字反转，因为之前都是前面的数字小于后面的数字，所以反转成升序，即把i后面的改为降序，（i后面的）排列变成最小值
        //这样才是找到的最小的下一个排列
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //自己写的，ac了
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 1;
        for (; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }
        int j = nums.length - 1;
        if (i >= 1) {
            for (; j >= i; j--) {
                if (nums[j] > nums[i - 1]) {
                    break;
                }
            }
            //需要放到if判断里面，因为有可能i-1<0
            swap(nums, i - 1, j);
        }
        reverse(nums, i);
    }

    public static void main(String[] args) {
        NextPermutation31 nextPermutation = new NextPermutation31();
        int[] nums = new int[]{1, 2, 3};
        nextPermutation.nextPermutation2(nums);
    }
}