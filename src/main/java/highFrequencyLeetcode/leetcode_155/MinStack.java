package highFrequencyLeetcode.leetcode_155;

import java.util.Stack;

/**
 * <p>
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *  push(x) -- 将元素 x 推入栈中。
 *  pop() -- 删除栈顶的元素。
 *  top() -- 获取栈顶元素。
 *  getMin() -- 检索栈中的最小元素。
 *
 *  示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 *
 * </p>
 * @author Seina
 * @version 2019-06-15 23:42:12
 */
public class MinStack {

    //java 中 int 的最大值
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack;
    public MinStack(){
        stack = new Stack<Integer>();
    }
    public void push(int x) {
        
        if (x <= min) {
            //先 push 原来的 min，因为一旦下一步操作把 min pop 了，也可以记录一下在这最小的元素，再赋给 min
            stack.push(min);
            //更新 min
            min = x;
        }
        // push x
        stack.push(x);
    }
    public void pop(){
        //如果 pop 的数等于 min
        if (stack.pop() == min) {
            //应该更新 min
            min = stack.pop();
        } 
    }

    public int top() {
        return stack.peek();
    }
    public int getMin(){
        return min;
    }
}
