package highFrequencyLeetcode.leetcode_25;

import leetcode.linkedlist.ListNode;

/**
 * <p>
 *
 *  给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 *  k 是一个正整数，它的值小于或等于链表的长度。
 *
 *  如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 *  示例 :
 *
 *  给定这个链表：1->2->3->4->5
 *
 *  当 k = 2 时，应当返回: 2->1->4->3->5
 *
 *  当 k = 3 时，应当返回: 3->2->1->4->5
 *
 *  说明 :
 *
 *  你的算法只能使用常数的额外空间。
 *  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-01-20 18:50:06
 */
public class ReverseNodesInkGroup {

    /**
     * 解法1
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
