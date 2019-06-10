package highFrequencyLeetcode.leetcode_24;

/**
 * Medium
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 问题：
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 1->2->3->4 | 2->1->4->3
 * <p>
 * 题解方案topics：
 * linked list
 *
 * @author li tong
 * @date 2019/6/6 9:41
 * @see Object
 * @since 1.0
 */
public class SwapNodes24 {

  public static class ListNode {
    int val;

    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      return "{" + val +
              ", next=" + next +
              '}';
    }
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    a.next = b;
    b.next = c;
    c.next = d;
//    understandSwapListRecursive(a);
    System.out.println(swapPairs(a));
//    System.out.println(swapPairs2(a));
  }

  /**
   * 解法1 递归法<p>
   * 看题解，主干思路：<p>
   * &nbsp;&nbsp; 定义后序二步节点 找到返回方程<p>
   * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
   * &nbsp;&nbsp; 如何找到返回方程 把单链表反转递归法又理解了一遍
   *
   * @param head
   * @return
   */
  public static ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      System.out.println();
      return head;
    }
    ListNode after = head.next;
    // 1 难点1 定义后序二步节点
    ListNode nextTwo = after.next;
    System.out.println(head + "就位，交代去程工作后，" + head.val + "睡眠，" + nextTwo + "进入到下一层");
    ListNode back = swapPairs(nextTwo);
    System.out.println("after=" + after + "返回到上一层，head=" + head + "唤醒，开始第一步：before指向back=" + back);
    // 2 难点2 谁指向谁？
    head.next = back;
    System.out.println("第一步完成后，head=" + head + "，开始第二步：after" + after + "指向before");
    // 3 难点3
    after.next = head;
    System.out.println("第二步完成后，after=" + after);
    System.out.println();
    // 4 难点4 返回什么？back 还是 after？
    return after;
  }

  /**
   * 解法2 遍历法<p>
   * 看题解，主干思路：<p>
   * &nbsp;&nbsp; 关键是要理解两步两步走<p>
   * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
   * &nbsp;&nbsp; 想不到定义两个Node
   *
   * @param head
   * @return
   */
  public static ListNode swapPairs2(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    ListNode newHead = new ListNode(0);
    newHead.next = head;
    ListNode temp = newHead;
    ListNode one = null;
    ListNode two = null;
    // {dummy->1->2->3->4->null}
    while (temp.next != null && temp.next.next != null) {
      // one -> 1
      one = temp.next;
      // two -> 2
      two = temp.next.next;
      // 1-> = 2.next = 3;
      one.next = two.next;
      // 2-> = 1
      two.next = one;
      // now newHead should point to 2
      // if the below is not done newHead->1;
      temp.next = two;
      // temp was pointing to newHead
      // temp->1
      temp = one;
      // now { dummy->2->1->3->4 }
    }
    return newHead.next;
  }

  /**
   * 自己理解递归方式链表反转
   * 4->3->2->1
   *
   * @param before
   * @return
   */
  public static ListNode understandSwapListRecursive(ListNode before) {
    if (before == null || before.next == null) {
      System.out.println("最底层的世界空无一物，" + before + "返回");
      System.out.println();
      return before;
    }
    ListNode after = before.next;
    System.out.println("before=" + before + "就位，交代去程工作后，before=" + before.val + "睡眠，after=" + after + "进入到下一层");
    ListNode back = understandSwapListRecursive(after);
    System.out.println("back=" + back + "返回到上一层，before=" + before + "唤醒，开始第一步：before指向null");
    /**
     * 回归这里是难点
     * 第一次失败 back.next = before; before.next = null; 第二次失败 before.next = null; back.next = before;
     * 模板中这里不写，也能正常执行，先调试看看
     */
    before.next = null;
    System.out.println("第一步完成后，before=" + before + "，开始第二步：after" + after + "指向before");
    after.next = before;
    System.out.println("第二步完成后，after=" + after + "，back=" + back);
    System.out.println();
    return back;
  }

}
