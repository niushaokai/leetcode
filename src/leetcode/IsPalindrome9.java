package leetcode;

/**
 * 回文数
 *
 * @author niushaokai
 * @date 2019-12-27
 */
public class IsPalindrome9 {

    public static boolean isPalindrome(int x) {
        int origin = x;

        if(x<0){
            return false;
        }else if(x == 0){
            return true;
        }

        int reverse = 0;
        while (x!=0){
            reverse = reverse*10+x%10;
            x /= 10;
        }
        if (origin == reverse){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        isPalindrome(121);
    }

}