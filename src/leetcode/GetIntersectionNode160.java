package leetcode;

import java.util.Stack;

/**
 * @author niushaokai
 * @date 2020/1/26
 */
public class GetIntersectionNode160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Stack<ListNode> stackA = new Stack<>();
        Stack<ListNode> stackB = new Stack<>();
        while (headA != null) {
            stackA.push(headA);
            headA = headA.next;
        }
        while (headB != null) {
            stackB.push(headB);
            headB = headB.next;
        }

        if (stackA.peek() != stackB.peek()) {
            return null;
        }

        ListNode res;
        ListNode before = stackA.pop();
        stackB.pop();
        while ((!stackA.isEmpty()) && (!stackB.isEmpty())) {
            res = stackA.peek();
            if (stackA.pop() == stackB.pop()) {
                before = res;
                continue;
            } else {
                break;
            }
        }
        return before;
    }

    //大神解法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
            if (pA == null && pB == null) {
                return null;
            }
            if (pA == null) {
                pA = headB;
            }
            if (pB == null) {
                pB = headA;
            }
        }
        return pA;
    }
}