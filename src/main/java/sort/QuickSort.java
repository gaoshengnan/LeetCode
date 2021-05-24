package sort;

public class QuickSort {

    public static void quickSort2 (int[] a, int head, int tail) {
        if (head >= tail) return;
        int i = head;
        int j = tail;
        int pivot = a[head];//pivot中存的就是基准数
        /**
         * 小数：比基准值小的数  大数：比基准值大的数
         * 右指针自右向左找小数
         * 左指针自左向右找大数
         * 然后交换
         * 最后的效果就是小数在左，大数在右
         */
        while (i < j) {//顺序很重要，要先从右边开始找
            //如果 j 指向节点比基准数大，继续挪动指针，否则就是比基准数小，说明找到了需要交换的数据，停止
            while (i < j && a[j] >= pivot) {
                j--;
            }
            //如果 i 指向节点比基准数小，继续挪动指针，否则就是比基准数大，说明找到了需要交换的数据，停止
            while (i < j && a[i] <= pivot) {
                i++;
            }
            if (i < j) {//交换两个数在数组中的位置
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        //最终将基准数归位
        a[head] = a[j];
        a[j] = pivot;
        quickSort2 (a, head, i - 1);//继续处理左边的，这里是一个递归的过程
        quickSort2(a, i + 1, tail);//继续处理右边的 ，这里是一个递归的过程
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 3, 1, 4};
        quickSort2(a, 0, 4);
        for (int aa : a
             ) {
            System.out.println("--");
            System.out.println(aa);
        }
    }

}
