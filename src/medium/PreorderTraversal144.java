package medium;

import java.util.*;

/**
 * 前序遍历
 *
 * @author niushaokai
 * @date 2020/3/24
 */
public class PreorderTraversal144 {
    //backtrace
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left != null) {
            result.addAll(preorderTraversal(root.left));
        }
        if (root.right != null) {
            result.addAll(preorderTraversal(root.right));
        }
        return result;
    }

    //backtrace method2
    public List<Integer> preorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, ArrayList<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        helper(root.left, list);
        helper(root.right, list);
    }


    //not backtrace
    public List<Integer> preorderTraversal6(TreeNode root) {
        HashMap map = new HashMap();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        List<Integer> res = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                res.add(p.val);
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
        }
        return res;
    }
}