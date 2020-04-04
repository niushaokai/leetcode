package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/9
 */
public class RotateRight61 {
    //官方题解
    public ListNode rotateRight(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;

        //引入n是为了取得链表的长度
        int n;
        //注意：这是个很有用的技巧，for循环中间的判断条件是old_tail.next != null，而且是next不能为空，而不是自己不能为空，因为需要让其next指向头
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        //链表的尾节点指向了链表头
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }

    public ListNode reverse(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oldHead = head;
        int length;
        for (length=1;head.next!=null;length++){
            head = head.next;
        }

        head.next = oldHead;

        for (int i = 0; i < length - k % length - 1; i++) {
            oldHead = oldHead.next;
        }
        ListNode newHead = oldHead.next;
        oldHead.next = null;
        return newHead;
    }
}