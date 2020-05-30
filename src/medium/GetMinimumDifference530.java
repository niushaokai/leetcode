package medium;

public class GetMinimumDifference530 {
    int last = -1;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorde(root);
        return min;
    }

    public void inorde(TreeNode root) {
        if (root == null) return;
        inorde(root.left);
        if (last == -1) {
            last = root.val;
        } else {
            min = (root.val - last) < min ? root.val - last : min;
            last = root.val;
        }
        inorde(root.right);
    }
}
