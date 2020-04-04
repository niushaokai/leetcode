package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/8
 */
public class MinDepth111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (root.left!=null){
            minDepth = Math.min(minDepth,minDepth(root.left));
        }
        if (root.right!=null){
            minDepth = Math.min(minDepth,minDepth(root.right));
        }
        return 1 + minDepth;
    }

    public int minDepth2(TreeNode root){
        if (root == null) {
            return 0;
        }

        if ((root.left == null) && (root.right == null)) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }
        return min_depth + 1;
    }
}