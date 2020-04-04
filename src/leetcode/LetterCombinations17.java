package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/3/14
 */
public class LetterCombinations17 {

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length()==0){
            return new ArrayList();
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        ArrayList<String> result = new ArrayList<>();
        search(0,result,map,digits,"");
        return result;

    }

    public void search(int level, ArrayList list, HashMap<Character, String> map, String digits, String temp) {
        if (level == digits.length()) {
            list.add(temp);
            return;
        }

        String target = map.get(digits.charAt(level));
        for (int i = 0; i < target.length(); i++) {
            search(level+1,list,map,digits,temp+target.charAt(i));
        }

    }


}