package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/7
 */
public class IsSymmetric101 {
    public boolean isSymmetric(TreeNode root) {
        //因为root就可能是空的
        return judge(root,root);
    }
    public boolean judge(TreeNode left,TreeNode right){
        if (left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }
        if (left.val != right.val){
            return false;
        }
        return judge(left.left,right.right)&&judge(left.right,right.left);
    }
}