package easy;

/**
 * @author niushaokai
 * @date 2020/4/14
 */
public class AddDigits258 {
    public int addDigits(int num) {
        while (num > 9) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num = num / 10;
            }
            num = temp;
        }
        return num;
    }

    public static void main(String[] args) {
        AddDigits258 addDigit = new AddDigits258();
        System.out.println(addDigit.addDigits(38));
    }
}