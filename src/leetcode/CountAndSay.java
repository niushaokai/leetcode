package leetcode;

/**
 * @author niushaokai
 * @date 2020/2/29
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        while (n > 1) {
            s += "#";
            String tmp = "";
            int count = 1;
            for (int i = 0; i < s.length() - 1; i++) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                } else {
                    tmp = tmp + count + s.charAt(i);
                    count = 1;
                }
            }
            s = tmp;
            n--;
        }
        return s;
    }
}