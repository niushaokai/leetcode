package medium;

import java.util.ArrayList;
import java.util.List;

public class Partition131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, result, new ArrayList<String>(), 0);
        return result;
    }


    public void helper(String s, List<List<String>> result, List<String> curList, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (judge(s.substring(index, i+1))){
                curList.add(s.substring(index, i + 1));
                helper(s, result, curList, index + 1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public boolean judge(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }



    public List<List<String>> partition2(String s) {
        ArrayList<List<String>> result = new ArrayList<List<String>>();
        if (s.length() == 0) return result;
        dfs(0,s,result,new ArrayList<String>());
        return result;
    }

    public void dfs(int index,String s,List<List<String>> result,ArrayList<String> current){
        //遍历完成
        if (index == s.length()) {
            //添加进结果中（由于java存储机制问题，建立新的数组）
            result.add(new ArrayList<String>(current));
            return;
        }
        //将字符串分割，依次判断是否为回文
        for (int i = index;i <= s.length()-1;i++){
            //判断所选是否为回文
            if (judge2(s.substring(index,i+1))) {
                current.add(s.substring(index,i+1));
                //判断剩余字符串是否由多个回文构成
                dfs(i+1,s,result,current);
                //回溯
                current.remove(current.size()-1);
            }
        }


    }
    //双指针判断是否为回文
    public boolean judge2(String sub){
        int first = 0;
        int second = sub.length()-1;
        while (first < second){
            if (sub.charAt(first) == sub.charAt(second)) {
                first++;
                second--;
            }else return false;
        }
        return true;
    }
}
