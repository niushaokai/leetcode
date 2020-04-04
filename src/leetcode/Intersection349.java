package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author niushaokai
 * @date 2020/1/25
 */
public class Intersection349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set2.add(nums2[i]);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer item : set1) {
            if (set2.contains(item)) {
                result.add(item);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}