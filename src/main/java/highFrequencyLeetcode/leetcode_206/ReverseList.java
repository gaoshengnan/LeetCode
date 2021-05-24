package highFrequencyLeetcode.leetcode_206;

import leetcode.linkedlist.ListNode;

/**
 * <p>
 *
 * 反转一个单链表。
 *
 *  示例:
 *
 *  输入: 1->2->3->4->5->NULL
 *  输出: 5->4->3->2->1->NULL
 *
 *  进阶:
 *  你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 *
 *  定义一个函数，输入一个链表的第一个结点，反转该链表并输出反转后链表的第一个结点。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-01-03 23:26:18
 *
 *
 */
public class ReverseList {

    /**
     * 解法1 迭代法
     * @param head ：头结点
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(1)
     *
     */
    public ListNode reverseList1(ListNode head){

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre= null;
        ListNode cur = head;
        ListNode next;

        while (cur != null){
            //将当前结点指向的下一个结点存起来赋值给next结点
            next = cur.next;
            //开始改变当前结点的指针 --> 指向上一个结点
            cur.next = pre;
            //开始移动指针，pre --> 移动到 cur
            pre = cur;
            //cur移动到最先存好的next
            cur = next;
        }
        return pre;
    }

    /**
     * 解法1 递归
     *
     * @param head ：头结点
     *
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     *
     */
    public ListNode reverseList2(ListNode head){
        //递归终止条件（newHead 指向尾节点）
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        //当前节点的下一个节点的下一个节点指向自己
        //简单理解就是由 1 -> 2 变成 1 <- 2
        head.next.next = head;
        //当前节点指向 null（递归结束的时候，这里就是尾节点指向 null）
        head.next = null;
        //newHead 经过层层递归，从正序链表的头节点走到尾节点（也就是反转的链表的首节点）
        //归来过程 newHead 一直都指向尾节点，归来的过程没有移动
        return newHead;
    }
}
