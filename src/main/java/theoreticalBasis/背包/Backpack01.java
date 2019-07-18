package theoreticalBasis.背包;

/**
 * @author Seina
 * @version 2019-07-17 21:16:27
 */
public class Backpack01 {

    private int maxW = Integer.MIN_VALUE;//-2515156415641
    private int[] weights = {2, 2, 4, 6, 3};//每个物品的重量
    private boolean[][] mem = new boolean[5][10];

    /**
     *
     * 解法1 回溯 + 记忆化递归
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
        if (mem[i][curLoadSum]) return;
        mem[i][curLoadSum] = true;
        f(i + 1, curLoadSum, n, bpWeight);//不装第 i 件物品
        if (curLoadSum + weights[i] <= bpWeight)//若加上 i 件物品，小于背包承载重量，再继续装
            f(i + 1, curLoadSum + weights[i], n, bpWeight);//装第 i 件物品
    }


    /**
     *
     * 解法2 动态规划
     *
     * @param n：物品个数
     * @param w: 当前已经装进去的物品的重量和
     * @return 最大可以装多少重量
     */
    private int dpBackpack (int n, int w) {
        boolean[][] states = new boolean[n][w + 1];
        states[0][0] = true;
        if (weights[0] <= w) states[0][weights[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= w - weights[i]; j++) {
                if (states[i - 1][j]) states[i][j] = states[i - 1][j];
            }
            for (int j = 0; j <= w - weights[i]; j++) {
                if (states[i - 1][j]) states[i][j + weights[i]] = true;
            }
        }

        for (int i = w; i >= 0; i--) {
            if (states[n - 1][i]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Backpack01 bp = new Backpack01();
        bp.f(0, 0, 5, 9);
    }
}