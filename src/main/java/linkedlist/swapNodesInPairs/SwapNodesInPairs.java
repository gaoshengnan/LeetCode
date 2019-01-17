package linkedlist.swapNodesInPairs;

import linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-16 22:35:25
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode root = new ListNode();
        root.next = head;
        ListNode pre = root;
        ListNode a;
        ListNode b;

        //a和b都不为空，才进入循环进行两两交换，并移动pre
        while (pre.next != null && pre.next.next != null) {
            a = pre.next;
            b = a.next;
            pre.next = b;
            a.next = b.next;
            b.next = a;
            pre = a;
        }
        return root.next;
    }

}
