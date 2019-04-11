package queue;

/**
 * @author Seina
 * @version 2019-04-02 11:50:44
 *
 * 用数组实现一个队列
 */
public class ArrayQueue {

    private String[] iterms;
    private int head; //队头下标
    private int tail; //队尾下标
    private int n; //数组大小

    public ArrayQueue(int capacity) {
        this.iterms = new String[capacity];
        this.head = 0;
        this.tail = 0;
        this.n = capacity;
    }


    /**
     * 队尾入队
     * @param iterm: 入队元素
     * @return 是否入队成功
     *
     *
     */
    public boolean enqueue(String iterm) {
        if (tail == n) {//tail指针走到指定大小的队列尾部
            if (head == 0) return false; //head在头部，tail在尾部，队列全满，返回false，表示入队失败
            //tail走到队尾，但是队列未满（head不是0）
            for (int i = head ; i<tail; i++) {
                iterms[i-head] = iterms[i];
            }
            tail -= head;
            head = 0;
        }
        iterms[tail] = iterm;
        tail ++;
        return true;
    }

    //队头出队
    public String dequeue() {
        if (head == tail) {//表示队列为空
            return null;
        }
        String temp = iterms[head];
        head ++;
        return temp;
    }


    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(2);
        queue.enqueue("haha");
        String temp = queue.dequeue();
        queue.enqueue("yaya");
        boolean result = queue.enqueue("yaya");
        String temp2 = queue.dequeue();
    }
}


