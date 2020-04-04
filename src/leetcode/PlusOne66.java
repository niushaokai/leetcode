package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/10
 */
public class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        boolean needExtend = false;
        if (digits[length - 1] != 9) {
            digits[length - 1] = digits[length - 1] + 1;
            return digits;
        } else {
            int carry = 1;
            for (int i = length - 1; i >= 0; i--) {
                int tempSum = digits[i]+carry;
                if (i == 0 && tempSum==10){
                    needExtend = true;
                }
                carry = tempSum/10;
                int realSum = tempSum%10;
                digits[i] = realSum;
            }
        }

        if (needExtend){
            int[] newArr = new int[length+1];
            newArr[0] = 1;
            for (int i =0;i<length;i++){
                newArr[i+1] = digits[i];
            }
            return newArr;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{9};
        plusOne(arr);
    }
}