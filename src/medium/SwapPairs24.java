package medium;

/**
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @author niushaokai
 * @date 2020/4/6
 */
public class SwapPairs24 {
    //递归
    public ListNode swapPairs(ListNode head) {
        // If the list has no node or has only one node left.
        if ((head == null) || (head.next == null)) {
            return head;
        }

        // Nodes to be swapped
        ListNode firstNode = head;
        ListNode secondNode = head.next;

        // Swapping
        firstNode.next  = swapPairs(secondNode.next);
        secondNode.next = firstNode;

        // Now the head is the second node
        return secondNode;
    }

    public ListNode swapPairs2(ListNode head) {

        // Dummy node acts as the prevNode for the head node
        // of the list and hence stores pointer to the head node.
        //创建dummy指向head
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prevNode = dummy;

        while ((head != null) && (head.next != null)) {

            // Nodes to be swapped
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // Swapping
            prevNode.next = secondNode;//这里dummy的next也会跟着变
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Reinitializing the head and prevNode for next swap
            prevNode = firstNode;//这句执行之后prevNode和dummy已经没关系了，prevNode怎么变都不会影响dummy了
            head = firstNode.next; // jump
        }

        // Return the new head node.
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapPairs24 swapPairs = new SwapPairs24();
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
//        swapPairs.swapPairs2(head);
        ListNode dummy = new ListNode(-1);
        System.out.println(dummy);
        dummy.next=head;
        ListNode pre = dummy;
        System.out.println(pre);
        System.out.println(pre == dummy);
        pre.next = node4;
        pre.next = node3;
        pre.next = node2;
        dummy.next = node5;

        pre = node3;
        System.out.println(pre);
        System.out.println(pre == dummy);

    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}