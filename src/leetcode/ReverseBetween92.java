package leetcode;

/**
 * @author niushaokai
 * @date 2020/1/8
 */
public class ReverseBetween92 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // 在头节点之前定义一个新的节点，preHead
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        // 定义一个cur节点，让其从preHead开始，先找到第m-1个节点，作为curPre
        ListNode cur = preHead;
        for (int i = 1; i < m; i++){
            cur = cur.next;
        }
        ListNode curPre = cur;
        cur = cur.next; // 现在cur为第m个节点
        // 从第m个节点到第n个节点，我们需要将n-m+1个节点进行翻转，那就是将n-m个节点插在第m个节点之前，因此需要n-m次操作
        // 进入循环之前需要定义一个curNext
        ListNode curNext;
        for (int i = 0; i < n - m; i++) {
            // 这个地方也可写成 for(int i = m; i < n; i++)
            curNext = cur.next;
            cur.next = curNext.next;
            curNext.next = curPre.next;
            curPre.next = curNext;
        }
        // 结束后，输出preHead.next即可
        return preHead.next;
    }
    public ListNode reversePart(ListNode head,int m,int n){
        ListNode preHead = new ListNode(0);

        return null;
    }

    public static void main(String[] args) {

    }

}