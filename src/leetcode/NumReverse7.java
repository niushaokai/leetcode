package leetcode;

/**
 * 整数反转
 *
 * @author niushaokai
 * @date 2019-12-27
 */
public class NumReverse7 {

    public static int reverse(int x) {
        if (x == 0) {
            return x;
        }

        int mark = 0;
        if (x > 0) {
            mark = 1;
        } else if (x < 0) {
            mark = -1;
        }

        String num = x+"";
        if (num.startsWith("-")){
            num = num.substring(1);
        }

        StringBuffer sb = new StringBuffer();
        for (int i = num.length()-1;i>=0;i--){
            sb.append(num.charAt(i));
        }

        String totalRes = "";
        if (mark==-1){
            totalRes = "-"+sb.toString();
        }else {
            totalRes = sb.toString();
        }
        int finalRes = 0;
        try {
            finalRes = Integer.valueOf(totalRes);
        }catch (Exception e){
            return 0;
        }

        return finalRes;


    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse2(-1234));
    }


    //大神解法
    public static int reverse2(int x) {
        int ans = 0;
        while (x != 0) {
            //防止溢出
            if ((ans * 10) / 10 != ans) {
                ans = 0;
                break;
            }
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return ans;
    }
}