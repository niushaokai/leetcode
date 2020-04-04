package easy;

import java.util.Arrays;

/**
 * @author niushaokai
 * @date 2020/3/23
 */
public class FindContentChildren455 {
    public int splitBiscuit(int[] children, int[] biscuit) {
        int res = 0;
        Arrays.sort(children);
        Arrays.sort(biscuit);
        int i = 0,j = 0;
        while (i<children.length && j<biscuit.length){
            if (children[i] <= biscuit[j]){
                i++;
                j++;
                res++;
            }else {
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindContentChildren455 findContentChildren455 = new FindContentChildren455();
        int[] children = new int[]{2, 3, 4};
        int[] biscuits = new int[]{3, 2, 5};
        int result = findContentChildren455.splitBiscuit(children, biscuits);
        System.out.println(result);
    }
}