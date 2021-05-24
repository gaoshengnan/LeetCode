package sort;

public class BubbleSort {


    // 冒泡排序，a 表示数组，n 表示数组大小
    public void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            //j < n-i-1
            //说明：首先选择小于而不是小于等于，表示索引下表需要减一
            // 其次 - i 表示去除之前冒泡操作排好序的元素：i 表示外层循环的次数，外层循环每跑一次，最大的数字会出现在末尾
            //最后 - 1，是因为下面代码有 j + 1，避免数组越界
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void main(String[] args) {
        int[] a = {4,3,5,2,1};
        BubbleSort b = new BubbleSort();
        b.bubbleSort(a, 5);
        for (int aa: a) {
            System.out.println(aa);
        }
    }
}
