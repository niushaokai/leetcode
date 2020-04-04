package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/3/17
 */
public class Combine77 {
    //从1-n，k个数的所有组合
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        enums(n, k, 1, new ArrayList<>(),result);
        return result;
    }

    public static void enums(int n, int k, int level, ArrayList<Integer> currentList, List<List<Integer>> result) {
        if (currentList.size() == k) {
            result.add(new ArrayList(currentList));
            return;
        }
        if (level>n){
            return;
        }
        enums(n, k, level + 1, currentList, result);
        currentList.add(level);
        enums(n, k, level + 1, currentList, result);

        currentList.remove(currentList.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(combine(4,2));
    }
}