package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/4/1
 */
public class Convert6 {
    public String convert(String s, int numRows) {
        if (numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            //第一行和最后一行该拐了
            //在第一行的时候flag=1，代表每次获取rows中的下一个StringBuilder
            //在最后一行的时候flag=-1，代表每次获取rows中的上一个StringBuilder
            if (i == 0 || i == numRows - 1) flag = -flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) res.append(row);
        return res.toString();
    }


    //自己写的
    public String convert2(String s, int numRows) {
        if (numRows < 2)
            return s;
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }

        int row = 0, flag = -1;
        for (char c : s.toCharArray()) {
            if (row == 0 || row == numRows - 1)
                flag = -flag;
            list.get(row).append(c);
            row += flag;
        }

        String result = "";
        for (StringBuilder sb : list) {
            result += sb.toString();
        }
        return result;
    }

    public static void main(String[] args) {
        Convert6 convert6 = new Convert6();
        String s = "LEETCODEISHIRING";
        System.out.println(convert6.convert2(s, 3));
    }

}
