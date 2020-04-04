package easy;

/**
 * @author niushaokai
 * @date 2020/3/18
 */
public class HasPathSum112 {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, 0, sum);
    }

    public boolean helper(TreeNode root, int cur, int sum) {
        if (root == null)
            return false;
        cur = cur + root.val;
        if (root.left == null && root.right == null) {
            return cur == sum;
        } else {
            return helper(root.left, cur, sum) || helper(root.right, cur, sum);
        }
    }

    //大神代码
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

}