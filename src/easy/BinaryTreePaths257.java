package easy;

import jdk.management.resource.internal.TotalResourceContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author niushaokai
 * @date 2020/3/16
 */
public class BinaryTreePaths257 {
    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        ArrayList<String> result = new ArrayList<>();
        backTrack(root, result, "");
        return result;
    }

    public static void backTrack(TreeNode root, ArrayList<String> result, String current) {
        if (root.left == null && root.right == null) {
            current += root.val;
            result.add(current);
            return;
        }

        if (root.left != null) {
            String temp = current + root.val;
            temp += "->";
            backTrack(root.left, result, temp);
        }

        if (root.right != null) {
            String temp = current + root.val;
            temp += "->";
            backTrack(root.right, result, temp);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode leaf = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.right = leaf;
        List<String> strings = binaryTreePaths(root);
        System.out.println(strings);
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