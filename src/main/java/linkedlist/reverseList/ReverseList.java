package linkedlist.reverseList;

import linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-03 23:26:18
 *
 * 定义一个函数，输入一个链表的第一个结点，反转该链表并输出反转后链表的第一个结点。
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

            //将当前结点的下一个结点赋值给next结点
            next = cur.next;

            //将当前结点的指针指向上一个结点
            cur.next = pre;

            //开始移动指针，pre --> 移动到 cur
            pre = cur;

            //cur移动到最先赋值好的next
            cur = next;
        }


        return pre;
    }
}
