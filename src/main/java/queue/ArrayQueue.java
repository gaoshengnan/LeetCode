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

    //队尾入队
    public boolean enqueue(String iterm) {
        if (tail == n) {//队列已满，不可以入队
            return false;
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
        ArrayQueue queue = new ArrayQueue(4);
        queue.enqueue("haha");
        queue.enqueue("yaya");
        String temp = queue.dequeue();
        String temp2 = queue.dequeue();
        String temp3 = queue.dequeue();
    }
}


