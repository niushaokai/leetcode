package leetcode;

import java.util.*;

/**
 * 中序遍历
 *
 * @author niushaokai
 * @date 2020/1/12
 */
public class InorderTraversal94 {
    //中序遍历
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        list.add(root.val);
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }

        return list;
    }

    //recursive
    public List<Integer> inorderTraversal3(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    public void helper(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    //非递归版
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque();
        List<Integer> results = new ArrayList();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                results.add(stack.peek().val);
                root = stack.peek().right;
                stack.pop();
            }
        }
        return results;
    }

    public List<Integer> inorder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()) {
                result.add(stack.peek().val);
                temp = stack.pop().right;
            }
        }
        return result;
    }
}