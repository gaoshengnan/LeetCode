package leetcode.stack.ImplementQueueUsingStacks;

import java.util.Stack;

/**
 * @author Seina
 * @version 2019-02-08 18:16:59
 */
public class ImplementQueueUsingStacks {

    //用两个栈互相倒实现队列

    Stack<Integer> stackA = new Stack<Integer>();
    Stack<Integer> stackB = new Stack<Integer>();


    /** Push element x to the back of leetcode.queue. */
    /** 将元素推到队列的尾部--->往队列里面添加一个元素（push往尾部推） */
    public void push(int x) {
        stackA.push(x);
    }

    /** Removes the element from in front of leetcode.queue and returns that element. */
    /** 从队列首部移除元素，并且返回这个元素--->移除元素（pop从首部往外蹦） */
    public int pop() {
        for (int i : stackA) {
            stackB.push(stackA.pop());
        }
        return stackB.pop();
    }

    /** Get the front element. */
    /** 得到队列首部的元素 */
    public int peek() {
        return stackB.pop();
    }

    /** Returns whether the leetcode.queue is empty. */
    /** 返回队列是否为null */
    public boolean empty() {
        return true;
    }
}
