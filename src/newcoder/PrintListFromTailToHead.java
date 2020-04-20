package newcoder;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author niushaokai
 * @date 2020/4/19
 */
public class PrintListFromTailToHead {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack = new Stack<>();
        while (listNode!=null){
            stack.push(listNode);
            listNode = listNode.next;
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()){
            result.add(stack.pop().val);
        }
        return result;
    }
}