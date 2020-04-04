package leetcode;

import java.util.*;

/**
 * @author niushaokai
 * @date 2020/1/28
 */
public class LevelOrderBottom107 {

    //全排列、102层次遍历
    //递归解决，递是发现问题，归是解决问题
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, 0, res);
        Collections.reverse(res);
        return res;
    }

    public void helper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth + 1 > res.size()) {
            res.add(new ArrayList());
        }
        res.get(depth).add(root.val);
        if (root.left != null) {
            helper(root.left, depth + 1, res);
        }
        if (root.right != null) {
            helper(root.right, depth + 1, res);
        }
    }

    //方法二：层次遍历反转
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
            }
            res.add(temp);
        }
        Collections.reverse(res);
        return res;
    }
}