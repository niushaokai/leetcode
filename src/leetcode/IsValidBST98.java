package leetcode;

import java.util.Stack;

/**
 * @author niushaokai
 * @date 2020/1/14
 */
public class IsValidBST98 {
    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        double min = -Double.MAX_VALUE;
        //注意：双层while是个技巧
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= min) {
                return false;
            }
            min = root.val;
            root = root.right;

        }
        return true;
    }

    //中序遍历
    public boolean isValidBST2(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (!helper(node.right, val, upper)) return false;
        if (!helper(node.left, lower, val)) return false;
        return true;
    }

    //高手，递归
    public boolean isValidBST3(TreeNode root) {
        return helper(root, null, null);
    }

}