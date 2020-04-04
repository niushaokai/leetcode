package medium;


/**
 * @author niushaokai
 * @date 2020/3/17
 */
public class Flatten114 {
    //将二叉树原地展开为链表
    private TreeNode pre = null;

    //递归，定义了全局变量pre
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    /**
     * 1.将左子树插入到右子树的地方
     * 2.将原来的右子树接到左子树的最右边节点
     * 3.考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     */
    public void flatten2(TreeNode root) {
        while (root != null) {
            //左子树为 null，直接考虑下一个节点
            if (root.left == null) {
                root = root.right;
            } else {
                // 找左子树最右边的节点
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                //将原来的右子树接到左子树的最右边节点
                pre.right = root.right;
                // 将左子树插入到右子树的地方
                root.right = root.left;
                root.left = null;
                // 考虑下一个节点
                root = root.right;
            }
        }
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}