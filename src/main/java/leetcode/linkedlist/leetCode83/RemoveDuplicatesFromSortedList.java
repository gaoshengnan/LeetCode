package leetcode.linkedlist.leetCode83;

import leetcode.linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-04-18 22:52:45
 */
public class RemoveDuplicatesFromSortedList {

    /*
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     *
     * Example 1:
     *
     * Input: 1->1->2
     * Output: 1->2
     *
     * Example 2:
     *
     * Input: 1->1->2->3->3
     * Output: 1->2->3
     *
     */

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;

        while (cur.next != null) {
            if (cur.data == cur.next.data) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }



}
