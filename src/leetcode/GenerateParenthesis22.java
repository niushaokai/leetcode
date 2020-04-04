package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/3/8
 */
public class GenerateParenthesis22 {
    private List<String> result;

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String s) {
        //terminator
        if (left == n && right == n) {
            result.add(s);
            return;
        }

        //process current logic:left,right

        //drill down
        if (left < n) {
            generate(left + 1, right, n, s + "(");
        }
        if (left > right) {
            generate(left, right + 1, n, s + ")");
        }

        //reverse states
    }
}