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
     *
     * @param head ：头结点
     * @return
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
            //开始改变当前结点的指针-->指向上一个结点
            cur.next = pre;
            //开始移动指针，pre --> 移动到 cur
            pre = cur;
            //cur移动到最先存好的next
            cur = next;
        }
        return pre;
    }
}
