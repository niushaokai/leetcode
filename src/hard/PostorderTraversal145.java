package hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后续遍历，这个最难，hard级别
 * @author niushaokai
 * @date 2020/3/24
 */
public class PostorderTraversal145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, ArrayList<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        helper(root.right, res);
        res.add(root.val);
    }


    //非递归  这种解法的思想是先序遍历的变形，先序遍历是“根->左->右”，
    //后序遍历是“左->右->根”，那么把先序遍历改成“根->右->左”，再逆序一下就是后序遍历。
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            //LinkedList可以作为栈使用，当在index为0的位置插入元素的时候，之前index为0的元素自动后移
            ans.add(0, node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    public void test(TreeNode root){
        List<Integer> ans = new LinkedList<>();
        if (root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()){
            node = stack.pop();

        }
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(0,1);
        list.add(0,2);
        list.add(0,3);
        for (Integer i:list){
            System.out.println(i);
        }
    }
}