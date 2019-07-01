package highFrequencyLeetcode.leetcode_142;

import leetcode.linkedlist.ListNode;

/**
 * <p>
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *  示例 1：
 *
 *  输入：head = [3,2,0,-4], pos = 1
 *  输出：tail connects to node index 1
 *  解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *  示例 2：
 *
 *  输入：head = [1,2], pos = 0
 *  输出：tail connects to node index 0
 *  解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *  示例 3：
 *
 *  输入：head = [1], pos = -1
 *  输出：no cycle
 *  解释：链表中没有环。
 *
 *  进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * </p>
 *
 * @author Seina
 * @version 2019-01-15 21:07:00
 *
 */
public class LinkedListCycleII {

    /**
     * 解法1
     *
     * 判断链表是否有环，如果有，返回入环结点
     * @param head: 链表头指针
     * @return 入环结点
     */
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
