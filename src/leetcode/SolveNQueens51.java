package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/3/14
 */
public class SolveNQueens51 {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> pie = new HashSet<>();
    HashSet<Integer> na = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }

        dfs(n, 0, new ArrayList());
        return generateNQueens(result, n);

    }

    //currentState存的是当前结果，eg.[1, 3, 0, 2]，表示第一行第二个位置是Q，第二行第4个位置是Q，第三行第1个位置是Q，第四行第3个位置是Q
    public void dfs(int n, int row, ArrayList<Integer> currentState) {
        //terminator
        if (row == n) {
            //因为递归回去的时候会把currentState里的元素remove掉，所以使用里clone
            result.add((ArrayList<Integer>) currentState.clone());
            return;
        }

        //current level,当前行的每一列都试一下
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || pie.contains(row + i) || na.contains(row - i)) {
                //go die
                continue;
            }

            //update the flags
            cols.add(i);
            pie.add(row + i);
            na.add(row - i);

            //drill down
            currentState.add(i);
            System.out.println(currentState);
            dfs(n, row + 1, currentState);

            //reverse，因为currentState是参数，需要在递归中传递，所以在本层递归改变后要恢复原来的值
            currentState.remove(currentState.size() - 1);
            cols.remove(i);
            pie.remove(row + i);
            na.remove(row - i);
        }
    }

    public List<List<String>> generateNQueens(ArrayList<ArrayList<Integer>> result, int n) {
        List<List<String>> ans = new ArrayList<>();
        for (ArrayList<Integer> innerList : result) {
            ArrayList<String> strings = new ArrayList<>();
            for (int i = 0; i < innerList.size(); i++) {
                String s = "";
                int position = innerList.get(i);
                for (int j = 0; j < n; j++) {
                    if (position == j) {
                        s += "Q";
                    } else {
                        s += ".";
                    }
                }
                strings.add(s);
            }
            ans.add(strings);
        }
        return ans;
    }
}