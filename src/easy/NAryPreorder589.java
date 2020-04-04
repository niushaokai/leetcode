package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/4/2
 */
public class NAryPreorder589 {
    //自己写的递归，一遍ac！！！
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root,result);
        return result;
    }

    public void helper(Node root, List<Integer> result) {
        if (root == null)
            return;
        result.add(root.val);
        if (root.children != null) {
            for (Node node : root.children) {
                helper(node, result);
            }
        }
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}