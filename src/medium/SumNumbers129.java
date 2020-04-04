package medium;

/**
 * @author niushaokai
 * @date 2020/3/18
 */
public class SumNumbers129 {
    int sum = 0, temp = 0;

    public int sumNumbers(TreeNode root) {
//        dfs(root);
//        return sum;
        return helper2(root,0);
    }

    //模仿大神代码
    public int helper2(TreeNode root,int ans){
        if (root == null){
            return 0;
        }
        int temp = ans*10+root.val;
        if (root.left == null && root.right == null){
            return temp;
        }
        return helper2(root.right,temp) + helper(root.left,temp);
    }




    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        temp = temp * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += temp;
        }
        if (root.left != null) {
            dfs(root.left);
        }
        if (root.right != null) {
            dfs(root.right);
        }
        temp /= 10;

    }

    //大神代码
    public int sumNumbers2(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int i) {
        if (root == null) return 0;
        int temp = i * 10 + root.val;
        if (root.left == null && root.right == null)
            return temp;
        return helper(root.left, temp) + helper(root.right, temp);
    }
}