package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/4/22
 */
public class Merge56 {
    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }

        // 按照起点排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        for (int i = 1; i < len; i++) {
            int[] curInterval = intervals[i];

            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
            int[] peek = res.get(res.size() - 1);

            if (curInterval[0] > peek[1]) {
                res.add(curInterval);
            } else {
                // 注意，这里应该取最大
                peek[1] = Math.max(curInterval[1], peek[1]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[][] merge2(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> container = new ArrayList<>();
        container.add(intervals[0]);
        for (int i = 1; i < len; i++) {
            int[] peek = container.get(container.size() - 1);
            if (peek[1] < intervals[i][0]) {
                container.add(intervals[i]);
            } else {
                peek[1] = Math.max(peek[1], intervals[i][1]);
            }
        }
        return container.toArray(new int[container.size()][]);
    }
}