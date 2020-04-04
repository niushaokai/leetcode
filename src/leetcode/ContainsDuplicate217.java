package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author niushaokai
 * @date 2020/2/29
 */
public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i:nums){
            if (set.contains(i)){
                return true;
            }else {
                set.add(i);
            }
        }
        return false;
    }
}