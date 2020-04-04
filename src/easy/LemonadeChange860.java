package easy;

/**
 * @author niushaokai
 * @date 2020/3/23
 */
public class LemonadeChange860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int temp : bills) {
            if (temp == 5) {
                five++;
            } else if (temp == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else if (temp == 20) {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange860 lemonadeChange = new LemonadeChange860();
        int[] bills = new int[]{5, 10, 5, 20};
        boolean res = lemonadeChange.lemonadeChange(bills);
        System.out.println(res);
    }
}