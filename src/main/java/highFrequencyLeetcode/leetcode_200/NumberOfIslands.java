package highFrequencyLeetcode.leetcode_200;

/**
 * <p>
 *
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 *  示例 1:
 *
 *  输入:
 *  11110
 *  11010
 *  11000
 *  00000
 *
 *  输出: 1
 *
 *
 *  示例 2:
 *
 *  输入:
 *  11000
 *  11000
 *  00100
 *  00011
 *
 *  输出: 3
 *
 * </p>
 *
 * @author Seina
 * @version 2019-07-04 21:28:48
 */
public class NumberOfIslands {

    /**
     * 解法1 染色 DFS
     *
     * 遇到岛屿就递归将其上下左右都从 1 -> 0，并且累加 岛屿数量
     *
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(1)
     *
     * @param gird：二维网格
     * @return 岛屿数量
     */
    public  int numIdlands(char[][] gird) {
        int count = 0;
        for (int i = 0; i < gird.length; i++) {
            for (int j = 0; j < gird[0].length; j++) {
                if (gird[i][j] == '1') {
                    dfsFill(gird, i, j);
                    count ++;
                }
            }
        }
        return count;
    }

    private void dfsFill(char[][] gird, int i, int j) {
        //是 1 再继续染色，否则退出
        if (i >= 0 && j >= 0 && i < gird.length && j < gird[0].length && gird[i][j] == '1') {
            gird[i][j] = '0';//把陆地 1 染成水 0，表示这个岛屿已经累加过了
            dfsFill(gird, i + 1, j);//下
            dfsFill(gird, i - 1, j);//上
            dfsFill(gird, i, j + 1);//右
            dfsFill(gird, i, j - 1);//左
        }
    }

    /**
     * 解法1 并查集
     *
     * 初始化二维表格中所有元素，在并查集中都指向自己，并将陆地 1 的数量累计到 count，然后遍历上下左右节点，发现陆地，就联合在一起，并同时 count--，最后返回 count 即是岛屿的数量
     *
     * 时间复杂度：O(m * n)
     * 空间复杂度：O(m * n)
     *
     * @param gird：二维网格
     * @return 岛屿数量
     */
    public static int numIslands2(char[][] gird) {
        if (gird.length == 0 || gird[0].length == 0) return 0;
        int m = gird.length, n = gird[0].length;//m = 4, n = 5
        UF uf = new UF(m, n, gird);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gird[i][j] == '0') continue;
                int p = i * n + j;//p：计算当前元素在并查集（一位数组）root 中的下标
                int q;//q：当前元素上下左右元素的下标
                if (i > 0 && gird[i - 1][j] == '1'){//判断上面元素
                    q = p - n;
                    uf.union(p, q);
                }
                if (i < m - 1 && gird[i + 1][j] == '1') {//判断下面元素
                    q = p + n;//当前元素下方向元素在 root 中的下标
                    uf.union(p, q);
                }
                if (j > 0 && gird[i][j - 1] == '1') {//判断左边元素
                    q = p -1;
                    uf.union(p, q);
                }
                if (j < n -1 && gird[i][j + 1] == '1') {//判断右边元素
                    q = p + 1;
                    uf.union(p, q);
                }
            }
        }
        return uf.count;
    }

    // 方便 debug
    public static void main(String[] args) {
        char[][] grid1 = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}};
        //int numIslands1 = numIslands2(grid1);

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}};
        //int numIslands2 = numIslands2(grid2);
    }
}
