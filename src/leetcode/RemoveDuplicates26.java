package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/6
 */
public class RemoveDuplicates26 {
    public static int removeDuplicates(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int i = 0;
//        for (int j = 1; j < nums.length; j++) {
//            if (nums[j] != nums[i]) {
//                i++;
//                nums[i] = nums[j];
//            }
//        }
//        return i + 1;


        int i = 0;
        int length = nums.length;
        if(length == 0){
            return 0;
        }
        for(int j = 1;j<length;j++){
            if(nums[j]!=nums[i]){
                i++;//注意：这两行的顺序一定不要反
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        removeDuplicates(arr);
    }
}
