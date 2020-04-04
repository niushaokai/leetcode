package leetcode;

import java.util.Arrays;

/**
 * @author niushaokai
 * @date 2020/1/10
 */
public class Rotate189 {
    public void rotate(int[] nums, int k) {
        int temp1, temp2, index, count = 0;//count为计数变量，记录移动成功的次数，temp1和temp2是辅助存储变量，为交换元素值之用
        int len = nums.length;
        k %= len;//对k值的前期处理，处理原因是如果k值比len大，那么只有大于len的那部分才是有效移动
        if (k == 0)
            return;//如果k等于0或者k原本是等于len的，那么就相当于没有移动嘛，直接返回
        for (int i = 0; i <= k; i++) //移动的轮数最多k次，当然计数变量count=len的时候会跳出循环
        {
            if (count >= len)
                break;//对计数变量的控制，当所有位置全部移动完了就可以结束了
            index = i;//每轮移动的初始下标
            temp1 = nums[i];
            while ((index + k) % len != i) //一个while循环移动一次
            {
                temp2 = nums[(index + k) % len];
                nums[(index + k) % len] = temp1;
                index = (index + k) % len;
                temp1 = temp2;
                count++;
            }
            nums[i] = temp1;
            count++;
        }
    }

    public static String rotate3(int[] nums, int k) {
        if (k < 0) {
            return null;
        }
        int length = nums.length;
        int[] arr = new int[length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            int index = (i + k) % length;
            arr[index] = nums[i];
        }
        return Arrays.toString(arr);
    }


    public static String rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            if (count >= nums.length) {
                break;
            }
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
        return Arrays.toString(nums);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        System.out.println(rotate3(nums, 3));
        ;
    }

}