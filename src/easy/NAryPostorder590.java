package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/4/2
 */
public class NAryPostorder590 {
    //自己写的递归，一遍ac
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }
    public void helper(Node root,List<Integer> result){
        if (root == null)
            return;
        if (root.children!=null){
            for(Node node : root.children){
                helper(node,result);
            }
        }
        result.add(root.val);
    }
}