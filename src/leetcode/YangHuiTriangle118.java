package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/2/26
 */
public class YangHuiTriangle118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            Integer[] arr = new Integer[i];
            if (i == 1) {
                arr[0] = 1;
                res.add(Arrays.asList(arr));
                continue;
            }
            if (i == 2) {
                arr[0] = arr[1] = 1;
                res.add(Arrays.asList(arr));
                continue;
            }
            List<Integer> last = res.get(i - 2);
            arr[0] = arr[i - 1] = 1;
            for (int j = 1; j < i - 1; j++) {
                arr[j] = last.get(j-1)+last.get(j);
            }

            res.add(Arrays.asList(arr));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}