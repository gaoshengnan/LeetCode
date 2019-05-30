package leetcode.stack;

/**
 * @author Seina
 * @version 2019-03-28 17:30:01
 *
 * 用数组实现一个栈，又称顺序栈
 */
public class ArrayStack {

    private String[] items;//数组
    private int count;//栈中元素个数
    private int n;//栈的大小


    //初始化数组，申请一个大小为n的数组空间
    private ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.n = n;
    }

    //入栈
    public boolean push(String item) {
        if (count == n) return false;
        items[count] = item;
        count++;
        return true;
    }

    //出栈，返回出栈元素
    public String pop() {
        if (count == 0) return null;
        String temp = items[count-1];
        --count;
        return temp;
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push("haha");
        stack.push("hehe");
        stack.push("yaya");
        String pop = stack.pop();

    }
}
