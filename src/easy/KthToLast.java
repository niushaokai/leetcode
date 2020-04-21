package easy;

/**
 * @author niushaokai
 * @date 2020/4/21
 */
public class KthToLast {

    public int kthToLast(ListNode head, int k) {
        ListNode quick = head;
        ListNode slow = head;
        int i = 0;
        while (i < k) {
            quick = quick.next;
            i += 1;
        }
        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }
        return slow.val;

    }
}