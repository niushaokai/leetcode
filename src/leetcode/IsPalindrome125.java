package leetcode;

import java.util.Stack;

/**
 * @author niushaokai
 * @date 2020/1/31
 */
public class IsPalindrome125 {

    //我的解法，用到了栈，所以空间复杂度很高
    public static boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        boolean res = true;
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
        }
        for (int i = 0; i < length; i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(stack.pop())) {
                    return false;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

    //高手解法，用到了双指针
    public static boolean isHuiwen(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}