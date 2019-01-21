package linkedlist.reverseNodesInkGroup;

import linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-20 18:50:06
 */
public class ReverseNodesInkGroup {

    /**
     *
     * @param head 链表第一个结点
     * @param k:是一个正整数，他的值小于或等于链表的长度
     * @return 反转后的链表第一个结点
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //k等于1，每1个结点进行翻转，相当于直接返回原始链表
        if (k < 2) {
            return head;
        }
        ListNode start;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next;
        int count = 1;
        while (cur != null) {
            next = cur.next;
            if (count == k) {
                start = pre == null ? head : pre.next;
                //head用来追踪链表反转过程中的第一个结点
                head = pre == null ? cur : head;
                resign(pre, start, cur, next);
                pre = start;
                count = 0;
            }
            count++;
            cur = next;
        }
        return head;
    }
    private void resign(ListNode left, ListNode start, ListNode end,
                       ListNode right) {
        ListNode p = start;
        ListNode c = start.next;
        ListNode n;
        while (c !=  right) {
            n = c.next;
            c.next = p;
            p = c;
            c = n;
        }
        if (left != null) {
            left.next = end;
        }
        start.next = right;
    }
}
