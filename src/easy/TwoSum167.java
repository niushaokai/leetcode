package easy;

/**
 * @author niushaokai
 * @date 2020/4/19
 */
public class TwoSum167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] < target) {
                start++;
            } else if (numbers[start] + numbers[end] > target) {
                end--;
            }else {
                result[0] = start+1;
                result[1] = end+1;
                break;
            }
        }
        return result;
    }
}