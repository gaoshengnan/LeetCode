package leetcode.backtrackingAlgorithm.leetcode_51;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Seina
 * @version 2019-05-30 17:08:35
 */
public class NQueens {

    public static void main(String[] args) {


//        int n = 4;
//        for (int column = 0; column < n; ++column) {
//            System.out.println(column);
//        }

        NQueens.solveNQueens(4);
    }





    public static List<List<String>> solveNQueens(int n) {

        List<String> list = new ArrayList<String>();

        List<List<String>> totalLists = new ArrayList<List<String>>();


        //下标表示行，值表示 queen 存储在哪一列
        int[] result = new int[n];

        //一级递归
        calNQueens(0, result, n);
        return null;

    }

    private static void calNQueens(int row, int[] result, int n) {

        //递归终止条件，n 行皇后都放完了，没办法再往下递归了
        if (row == n) {
            printQueens(result);
            return;
        }

        //循环控制每一列，每一行有 n 个列，有 n 种放法
        for (int column = 0; column < n; ++column) {
            if (isOk(row, column, result)) {
                //把第 row 行的棋子放在了第 column 列
                result[row] = column;

                //继续递归下一行
                calNQueens(row + 1, result, n);
            }
        }
    }

    //判断 row 行和 column 列位置是否合适放皇后
    private static boolean isOk(int row, int column, int[] result) {

        int leftCol = column - 1, rightCol = column + 1;

        //外层循环控制行数，逐行往上考察
        for (int i = row - 1; i >= 0; --i) {

            /**
             * 第一步：检查同一列
             *
             */
            if (result[i] == column) return false;

            /**
             *  第二步：检查对角线
             *
             *  比如当前检查 Q 的位置是否可以
             *  控制对角线的移动：向上循环row - 1，以及左列 leftCol-- 和右列 rightCol++
             *  逐一考察左上对角线和右上对角线，即两个 C 的位置是否可以
             *
             * * * *                 * * * *                 C * * *
             * * * *                 * C * *                 * C * *
             * * Q *        -->      * * Q *       -->       * * Q *
             * * * *                 * * * *                 * * * *
             *
             */
            //考察左上对角线，第 i 行的 leftUp 有皇后吗
            if (leftCol >= 0) {
                if (result[i] == leftCol) return false;
            }

            //考察右上对角线，第 i 行的 rightUp 有皇后吗
            if (rightCol < 8) {
                if (result[i] == rightCol) return false;
            }

            --leftCol;
            ++rightCol;
        }
        return true;
    }

    //打印出一个二维矩阵
    private static void printQueens(int[] result) {
        for (int row = 0; row < result.length; ++row) {
            for (int column = 0; column < result.length; ++column) {
                if (result[row] == column) System.out.print("Q ");
                else System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
