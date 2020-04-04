package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/7
 */
public class IsSameTree100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        } else if (q == null || p == null) {
            return false;
        }


        if (p.val == q.val) {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else {
            return false;
        }


    }
}