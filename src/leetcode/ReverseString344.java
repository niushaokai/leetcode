package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/26
 */
public class ReverseString344 {
    public void reverseString(char[] s) {

        int length = s.length;
        int j = length - 1;
        for (int i = 0; i < length; i++) {
            if (i<j){
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
                j--;
            }else {
                break;
            }
        }
    }
}