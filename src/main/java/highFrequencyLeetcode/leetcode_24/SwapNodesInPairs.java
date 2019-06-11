package highFrequencyLeetcode.leetcode_24;

import leetcode.linkedlist.ListNode;

/**
 * <p>
 * 
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 
 * </p>
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
