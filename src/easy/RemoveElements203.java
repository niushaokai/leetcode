package easy;

/**
 * @author niushaokai
 * @date 2020/4/16
 */
public class RemoveElements203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }


    public ListNode removeElements3(ListNode head, int val) {
        ListNode pre = new ListNode(0);
        pre.next = head;

        ListNode preHandle = pre;  //代表指针,真正改变的是pre和head
        ListNode curHandle = head;  //代表指针,真正改变的是pre和head
        while (curHandle != null) {
            if (curHandle.val == val) {
                preHandle.next = curHandle.next;
            } else {
                preHandle = curHandle;
            }
            curHandle = curHandle.next;
        }
        return pre.next;
    }

    public static void main(String[] args) {
        RemoveElements203 removeElements = new RemoveElements203();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node33 = new ListNode(6);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node33;
        node33.next = node4;
        node4.next = node5;
        node5.next = node6;

        removeElements.removeElements3(node1, 6);
        while (node1 != null) {
            System.out.println(node1.val);
            node1 = node1.next;
        }

    }
}