package linkedlist.reverseList;

import linkedlist.ListNode;

/**
 * @author Seina
 * @version 2019-01-03 23:26:18
 *
 * 定义一个函数，输入一个链表的第一个结点，反转该链表并输出反转后链表的第一个结点。
 */
public class ReverseList {

    /**
     * 迭代法
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
