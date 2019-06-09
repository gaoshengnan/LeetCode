package highFrequencyLeetcode.leetcode_69;

/**
 * Easy
 * (注解文档查看快捷键 选中类名或方法名 按ctrl + Q)
 * <p>
 * 思维全过程记录方案：<p>
 * 1 背基础结构和算法      | 记录在课程笔记<p>
 * 2 看题 -> 悟题 思考过程 | 记录在wiki<p>
 * 3 悟题 -> 写题 实现难点 | 记录在代码注解<p>
 * 4 写题 -> 优化 多种解法 | 记录在leetcode提交
 * <p>
 * 题解方案topics：
 * math、binary search
 *
 * @author li tong
 * @date 2019/6/5 9:43
 * @see Object
 * @since 1.0
 */
public class Sqrt69 {

    public static void main(String[] args) {
        System.out.println("BINARY=" + binary(1000000));
        System.out.println();

        System.out.println("BINARYTWO=" + binaryTwo(1000000));
        System.out.println();

        System.out.println("NEWTON=" + newton(5));
        System.out.println();

        for (int i = 0; i < 101; i++) {
            System.out.println("i" + i + " => " + newton(i));
        }
    }

    /**
     * 解法1 递归<p>
     * 自己思考，主干思路：<p>
     * &nbsp;&nbsp;二分查找<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;一些边界条件
     *
     * @param x
     * @return
     */
    public static int binary(int x) {
        double left = 0;
        double middle = x / 2;
        double right = x - 1;
        return help(left, middle, right, x);
    }

    private static int help(double left, double middle, double right, int x) {
        int result;
        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        if (left == middle || right == middle) {
            return (int) middle;
        }
        if (left > middle || right < middle) {
            return (int) left;
        }
        if (middle * middle == x) {
            result = (int) middle;
        } else if (middle * middle < x) {
            // 找右半边
            left = middle;
            middle = (left + right) / 2;
            result = help(left, middle, right, x);
        } else {
            // 找左半边
            right = middle;
            middle = (left + right) / 2;
            result = help(left, middle, right, x);
        }
        return result;
    }

    /**
     * 解法2 递归转循环<p>
     * 看题解，主干思路：<p>
     * &nbsp;&nbsp;二分查找<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;递归如何转循环？
     *
     * @param x
     * @return
     */
    public static int binaryTwo(int x) {
        if (x <= 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        double left = 0;
        double right = x - 1;
        // 关键
        while (left < right) {
            double middle = (right + left) / 2;
            if (middle * middle == x || left == middle || right == middle) {
                return (int) middle;
            } else if (middle * middle < x) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return (int) right;
    }

    /**
     * 解法3 牛顿法<p>
     * 看题解，主干思路：<p>
     * &nbsp;&nbsp;牛顿导数公式<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     * &nbsp;&nbsp;公式如何转换成代码
     *
     * @param x
     * @return
     */
    public static int newton(int x) {
        // Caution 1 注意数据类型 long
        long res = x;
        while (res * res > x) {
            // Caution 2 公式
            res = (res + x / res) / 2;
        }
        return (int) res;
    }

}
