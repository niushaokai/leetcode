package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/8
 */
public class MaxDepth104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}