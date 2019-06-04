package leetcode.stack.leetcode_42;

import java.util.Stack;

/**
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 题解方案topics：
 * dp、stack、双指针
 *
 * @author li tong
 * @date 2019/6/3 10:18
 * @see Object
 * @since 1.0
 */
public class TrappingRainWater42 {

    public static void main(String[] args) {
        int[] testcase = new int[]{2, 0, 2}; // 0, 2, 0
        System.out.println("FORCE=" + bruteForce(testcase));
        System.out.println();
        System.out.println("DPONE=" + dpOne(testcase));
        System.out.println();
        System.out.println("DPTWO=" + dpTwo(testcase));
        System.out.println();
        System.out.println("STACK=" + stack(testcase));
    }

    /**
     * 解法1 暴力求解<p>
     * 看题解，提取主干思路：<p>
     * &nbsp;&nbsp;从左向右遍历整个下标 每个下标从左、右分别找出最高的杆子<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;看了题解才知道居然要从左、右分头遍历，这个一开始是想不到的
     *
     * @param columns
     * @return
     */
    public static int bruteForce(int[] columns) {
        int result = 0, length = columns.length;
        for (int i = 0; i < length; i++) {
            // Caution 1 声明位置在for循环里面而不是外面
            int maxl = 0, maxr = 0;
            for (int j = i; j < length; j++) {
                maxr = Math.max(maxr, columns[j]);
            }
            for (int j = i; j >= 0; j--) {
                maxl = Math.max(maxl, columns[j]);
            }
            result += Math.min(maxl, maxr) - columns[i];
        }
        return result;
    }

    /**
     * 解法2 DP求解<p>
     * 看题解，提取主干思路：<p>
     * &nbsp;&nbsp;在解法一的基础上 由于是求极值问题 考虑DP<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;由于在暴力求解中DP递推方程已得出，现在需要思考<p>
     * &nbsp;&nbsp;1 如何用dp的方式遍历 还是和暴力一样吗？<p>
     * &nbsp;&nbsp;2 如何归并？<p>
     * &nbsp;&nbsp;看完样例代码，发现遍历的顺序和暴力是有区别的，为什么？<p>
     *
     * @param columns
     * @return
     */
    public static int dpOne(int[] columns) {
        // Caution 1 if length == 0
        if (columns.length == 0) {
            return 0;
        }
        int result = 0, length = columns.length;
        int[] maxl = new int[columns.length];
        int[] maxr = new int[columns.length];
        maxl[0] = columns[0];
        // Caution 2 length - 1
        maxr[length - 1] = columns[length - 1];
        for (int i = 1; i < length; i++) {
            // Caution 3 i - 1 i + 1
            maxl[i] = Math.max(maxl[i - 1], columns[i]);
        }
        // Caution 4 length - 2
        for (int i = length - 2; i >= 0; i--) {
            maxr[i] = Math.max(maxr[i + 1], columns[i]);
        }
        for (int i = 1; i < columns.length - 1; i++) {
            result += Math.min(maxl[i], maxr[i]) - columns[i];
        }
        return result;
    }

    /**
     * 解法3 DP求解 单次遍历<p>
     * 看题解，提取主干思路：<p>
     * &nbsp;&nbsp;双指针替换两次遍历<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;虽然用dp存储了一些计算结果，但还是和暴力一样遍历了两次，如何减少循环次数？<p>
     *
     * @param h
     * @return
     */
    public static int dpTwo(int[] h) {
        int result = 0, left = 0, right = h.length - 1;
        int maxl = 0, maxr = 0;
        while (left < right) {
            if (h[left] < h[right]) {
                if (h[left] >= maxl) {
                    maxl = h[left];
                } else {
                    result += (maxl - h[left]);
                }
                ++left;
            } else {
                if (h[right] >= maxr) {
                    maxr = h[right];
                } else {
                    result += (maxr - h[right]);
                }
                --right;
            }
        }
        return result;
    }

    /**
     * 解法4 栈解法<p>
     * 看题解，提取主干思路：<p>
     * &nbsp;&nbsp;使用栈标记低谷和两界<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;1 很难想到<p>
     * &nbsp;&nbsp;2 即便看了答案也是很难理解<p>
     *
     * @param columns
     * @return
     */
    public static int stack(int[] columns) {
        int result = 0, cursor = 0, length = columns.length;
        Stack<Integer> stack = new Stack<>();
        while (cursor < length) {
//            System.out.print("CURSOR" + cursor + "->");
//            System.out.print("COLUMN");
            if (stack.isEmpty() || columns[cursor] < columns[stack.peek()]) {
//                System.out.println(cursor + "+");
                stack.push(cursor++);
            } else {
                int bottom = stack.pop();
//                System.out.print(bottom + "- RESULT+");
                if (stack.isEmpty()) {
//                    System.out.println(0);
                    continue;
                }
                int left = stack.peek();
                int square = (Math.min(columns[left], columns[cursor]) - columns[bottom]) * (cursor - left - 1);
//                System.out.println(square);
                result += square;
            }
        }
        return result;
    }

}
