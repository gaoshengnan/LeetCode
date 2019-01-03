package linkedlist.reverseList;

import linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-03 23:26:18
 */
public class ReverseList {

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre= null;
        ListNode cur = head;
        ListNode next;

        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
