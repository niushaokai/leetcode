package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author niushaokai
 * @date 2019-12-25
 */
public class LengthOfLongestSubstring3 {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(solution(s));
    }

    //方法一：暴力求解
    public static int solution(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (unique(s, i, j)) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        return ans;
    }

    public static boolean unique(String s, int start, int end) {
        HashSet<Character> set = new HashSet<>();
        for (int i = start; i < end; i++) {
            if (set.contains(s.charAt(i))) {
                return false;
            } else {
                set.add(s.charAt(i));
            }
        }
        return true;
    }


    //方法二：滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}