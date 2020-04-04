package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author niushaokai
 * @date 2020/1/12
 *
 * 自定义排序：
 * 想法:为了构建最大数字，我们希望越高位的数字越大越好。
 *
 * 算法:
 * 首先，我们将每个整数变成字符串。然后进行排序。
 * 如果仅按降序排序，有相同的开头数字的时候会出现问题。比方说，样例 2 按降序排序得到的数字是 9534330395343303 ，
 * 然而交换 33 和 3030 的位置可以得到正确答案 95343309534330 。
 * 因此，每一对数在排序的比较过程中，我们比较两种连接顺序哪一种更好。我们可以证明这样的做法是正确的：
 * 假设（不是一般性），某一对整数 aa 和 bb ，我们的比较结果是 aa 应该在 bb 前面，这意味着 a\frown b > b\frown aa⌢b>b⌢a ，
 * 其中 \frown⌢ 表示连接。如果排序结果是错的，说明存在一个 cc ， bb 在 cc 前面且 cc 在 aa 的前面。
 * 这产生了矛盾，因为 a\frown b > b\frown aa⌢b>b⌢a 和 b\frown c > c\frown bb⌢c>c⌢b 意味着 a\frown c > c\frown aa⌢c>c⌢a 。
 * 换言之，我们的自定义比较方法保证了传递性，所以这样子排序是对的。
 *
 * 一旦数组排好了序，最“重要”的数字会在最前面。有一个需要注意的情况是如果数组只包含 0 ，我们直接返回结果 00 即可。否则，我们用排好序的数组形成一个字符串并返回。
 */
public class LargestNumber179 {
    public static Comparator<String> stringComparator = new Comparator<String>() {
        @Override
        public int compare(String x, String y) {
            String rear = y+x;
            String tail = x+y;
            int res = rear.compareTo(tail);
            return res;
        }
    };

    public static String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        //sorted函数中参数表示自己定义了一个比较器的比较规则
//        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).forEach(x -> res.append(x));
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted(stringComparator).forEach(x -> res.append(x));
        return res.charAt(0) == '0' ? "0" : res.toString();
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,30,34,5,9};
//        List<String> collect = Arrays.stream(arr).boxed().map(x -> x.toString()).sorted((x, y) -> (y + x).compareTo(x + y)).collect(Collectors.toList());
//        System.out.println(collect);
        System.out.println(largestNumber(arr));
    }

    public String largestNumber2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(nums).boxed().map(x -> x.toString()).sorted((x,y)->(y+x).compareTo(x+y)).forEach(item->sb.append(item));
        return sb.toString().charAt(0) == '0'?"0":sb.toString();
    }
}

