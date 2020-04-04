package leetcode;

/**
 * @author niushaokai
 * @date 2019-12-30
 */

public class ReverseList206 {

    public ListNode reverseList(ListNode head){
        ListNode tail = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = tail;
            tail = cur;
            cur = temp;
        }

        //return cur不可以，因为cur最后会等于null
        return tail;
    }
}