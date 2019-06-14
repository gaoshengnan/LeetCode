package highFrequencyLeetcode.leetcode_21;



/**
 *
 * <p>
 *
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 *  示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 *
 * </p>
 *
 * @author Seina
 * @version 2019-04-19 08:20:26
 */
public class MergeTwoSortedLists {

    /**
     * 递归
     * 时间复杂度: O(m + n)
     * 空间复杂度: O(1)
     * 
     * 
     * @param l1 
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        //递归终止时，返回的是两个链表中最大的节点
        if (l1 == null) {
            return l2;
        } 
        else if (l2 == null) {
            return l1;
        } 
        //每一层递归在做的事情：
        //如果 l1 < l2，则越过 l1，也就是 l1 = l1.next; 否则 l2 = l2.next
        else if (l1.val < l2.val){
            //当 l1.next == null 时，进入到 mergeTwoLists(null, l2)，返回 l2，然后为了让 l1 链接上 l2，所以 l1.next = mergeTwoLists(null, l2) = l2
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        } 
        else {
            //当 l2.next == null 时，进入到 mergeTwoLists(l1, null)，返回 l1，然后为了让 l2 链接上 l11，所以 l2.next = mergeTwoLists(l1, null) = l1
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }
    }


    /**
     * 非递归
     * 时间复杂度: O(n)
     * 空间复杂度: O(1)
     * 
     * 
     * @param l1 
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        //定义一个节点数据域是 -1 的节点
        ListNode prehead = new ListNode(-1);
        //p 指针指向 -1 节点
        ListNode p = prehead;

        while (l1 != null && l2 != null) {
            //l1 和 l2 谁小，p.nexrt 就等于谁
            if (l1.val <= l2.val) {
                //prehead 连接 l1
                p.next = l1;
                //继续判断 l1 的下一个节点
                l1 = l1.next;
            } else {
                //否则 prehead 连接 l2
                p.next = l2;
                //继续判断 l2 的下一个节点
                l2 = l2.next;
            }
            p = p.next;
        }
        p.next = l1 == null ? l2 : l1;
        return prehead.next;

    }
}
