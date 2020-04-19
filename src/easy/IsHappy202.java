package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author niushaokai
 * @date 2020/4/19
 */
public class IsHappy202 {
    public boolean isHappy(int n) {
        //如果不是快乐数，最终会进入循环，为什么？证明请看官方题解
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        while (n >= 0) {
            if (n > 0) {
                int a = n % 10;
                sum += a * a;
                n /= 10;
            } else {
                if (sum == 1)
                    return true;
                if (set.contains(sum)){
                    return false;
                }
                n = sum;
                set.add(sum);
                sum = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IsHappy202 isHappy = new IsHappy202();
        System.out.println(isHappy.isHappy(2));
    }
}