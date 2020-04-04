package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryLevelOrder429 {
    //多叉树的层次遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList();
        if (root == null)
            return result;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        //不可行，因为queue是变化的，这里需要用到双层while
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            ArrayList<Integer> tempList = new ArrayList();
//            for (int i = 0;i<size;i++){
//                Node temp = queue.poll();
//                tempList.add(temp.val);
//            }
//
//        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> tempList = new ArrayList<>();
            while (size > 0) {
                root = queue.poll();
                tempList.add(root.val);
                if (root.children != null) {
                    for (Node node : root.children) {
                        queue.add(node);
                    }
                }
                size--;
            }
            //这个地方最开始的时候没有发现这个问题
            //如果不加这个判断会出现问题，输入[]，预期[]，但是输出却是[[]]
            //所以要加这个循环
            if (tempList.size() > 0) {
                result.add(tempList);
            }

        }
        return result;
    }


    //二叉树的层次遍历
    public void levelOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        List<TreeNode> allNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode head = queue.poll();
            if (head.left != null) {
                queue.offer(head.left);
            }
            if (head.right != null) {
                queue.offer(head.right);
            }
            allNodes.add(head);
        }
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}