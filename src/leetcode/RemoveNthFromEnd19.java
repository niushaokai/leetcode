package leetcode;

/**
 * @author niushaokai
 * @date 2020-01-03
 */
public class RemoveNthFromEnd19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //思路是对的，但是边界值处理不好
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        int i = 0;
        while (i<n+1){
            fast = fast.next;
            i++;
        }
        while (fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

//        ListNode dummy = new ListNode(0);
//        dummy.next = head;
//        ListNode first = dummy;
//        ListNode second = dummy;
//        // Advances first pointer so that the gap between first and second is n nodes apart
//        for (int i = 1; i <= n + 1; i++) {
//            first = first.next;
//        }
//        // Move first to the end, maintaining the gap
//        while (first != null) {
//            first = first.next;
//            second = second.next;
//        }
//        second.next = second.next.next;
//        return dummy.next;
    }
}