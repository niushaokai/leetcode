package hard;

/**
 * @author niushaokai
 * @date 2020/4/21
 */
public class LongestValidParentheses32 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
                if (right == left) {
                    max = Math.max(max, right * 2);
                } else if (right > left) {
                    left = right = 0;
                }
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i)==')'){
                right++;
            }else {
                left++;
                if (left == right){
                    max = Math.max(max,2*left);
                }else if(left>right){
                    left = right = 0;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        LongestValidParentheses32 longest = new LongestValidParentheses32();
        String s = "(()";
        System.out.println(longest.longestValidParentheses(s));
    }
}