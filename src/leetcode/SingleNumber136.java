package leetcode;

import java.util.HashMap;
import java.util.Set;

/**
 * @author niushaokai
 * @date 2020/1/7
 */
public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                int count = map.get(nums[i]);
                map.put(nums[i],count+1);
            }else {
                map.put(nums[i],1);
            }
        }
        Set<Integer> keys = map.keySet();
        for (Integer key:keys){
            if (map.get(key) == 1){
                return key;
            }
        }
        return 0;
    }

    //大神解法
    /**
     * 如果我们对 0 和二进制位做 XOR 运算，得到的仍然是这个二进制位
     * a \oplus 0 = aa⊕0=a
     * 如果我们对相同的二进制位做 XOR 运算，返回的结果是 0
     * a \oplus a = 0a⊕a=0
     * XOR 满足交换律和结合律
     * a \oplus b \oplus a = (a \oplus a) \oplus b = 0 \oplus b = ba⊕b⊕a=(a⊕a)⊕b=0⊕b=b
     * 所以我们只需要将所有的数进行 XOR 操作，得到那个唯一的数字。
     *
     * 作者：LeetCode
     * 链接：https://leetcode-cn.com/problems/single-number/solution/zhi-chu-xian-yi-ci-de-shu-zi-by-leetcode/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * */
    public int singleNumber2(int[] nums) {
        int res = nums[0];
        for(int i =1;i<nums.length;i++){
            //异或
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,2,1,2};
        singleNumber(arr);
    }
}