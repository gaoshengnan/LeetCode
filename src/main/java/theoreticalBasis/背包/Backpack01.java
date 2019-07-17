package theoreticalBasis.背包;

/**
 * @author Seina
 * @version 2019-07-17 21:16:27
 */
public class Backpack01 {

    private int maxW = Integer.MIN_VALUE;//-2515156415641
    private int[] weights = {2, 2, 4, 6, 3};//每个物品的重量

    /**
     *
     * 解法1 回溯算法
     *
     * @param i: 考察到哪个物品
     * @param curLoadSum: 当前已经装进去的物品的重量和
     * @param n：物品个数
     * @param bpWeight：背包重量
     */
    private void f(int i, int curLoadSum, int n, int bpWeight) {
        if (curLoadSum == bpWeight || i == n) {//装满了或者物品全部考察完
            //if (curLoadSum > maxW) maxW = curLoadSum;
            maxW = Math.max(maxW, curLoadSum);
            return;
        }
        f(i + 1, curLoadSum, n, bpWeight);//不装第 i 件物品
        if (curLoadSum + weights[i] <= bpWeight)
            f(i + 1, curLoadSum + weights[i], n, bpWeight);//装第 i 件物品
    }


    public static void main(String[] args) {
        Backpack01 bp = new Backpack01();
        bp.f(0, 0, 5, 9);
    }

}