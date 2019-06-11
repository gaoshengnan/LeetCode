package highFrequencyLeetcode.leetcode_142;

import leetcode.linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-15 21:07:00
 *
 * 判断链表是否有环，如果有，返回入环结点
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode low = head;

        //标识是否有环
        boolean hasCycle = false;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            low = low.next;
            if (fast == low){
                hasCycle = true;
                break;
            }
        }

        //如果有环，求出入环结点
        if (hasCycle){
            fast = head;
            while (fast != low){
                fast = fast.next;
                low = low.next;
            }
            return low;
        }

        ///如果没有环，返回null
        return null;
    }
}
