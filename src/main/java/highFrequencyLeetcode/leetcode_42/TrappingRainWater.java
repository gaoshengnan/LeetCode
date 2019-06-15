package highFrequencyLeetcode.leetcode_42;

import java.util.Stack;

/**
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 *
 * 示例:
 *
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * <p>
 *
 * @author li tong，Seina
 * @version 2019/6/3 10:18
 */
public class TrappingRainWater {

    /**
     * 解法1 暴力求解
     * 
     * 第一层循环从左向右遍历，第二层循环分别找出当前节点左右最大的值，然后取其中一个最小的减去自己本身的高度，就是当前节点上面可以放多少水，最后累加
     * 
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     *
     * @param height: 宽度为 1 的柱子高度
     * @return 能接多少雨水
     */
    public int trap1(int[] height) { 
        int result = 0, length = height.length;
        for (int i = 0; i < length; i++) {
            // Caution 1 声明位置在for循环里面而不是外面
            int maxL = 0, maxR = 0;
            //取 i 右边最高（包括自己）
            for (int j = i; j < length; j++) {
                maxR = Math.max(maxR, height[j]);
            }
            //取 i 左边最高（包括自己）
            for (int j = i; j >= 0; j--) {
                maxL = Math.max(maxL, height[j]);
            }
            //最后将每个 i 上面可以承担的水累加
            result += Math.min(maxL, maxR) - height[i];
        }
        return result;
    }

    /**
     * 解法2 动态编程
     * 
     * 两次循环将每个元素左边最高的柱子和每个元素右边最高的柱子存储在数组里，然后在每个元素的左边最高和右边最高中取最小 - 自己本身的高度，再累加
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param height: 宽度为 1 的柱子高度
     * @return 能接多少雨水
     */
    public int trap2(int[] height) {
        // Caution 1 if length == 0
        if (height.length == 0) {
            return 0;
        }
        int result = 0, length = height.length;
        int[] maxL = new int[length];
        int[] maxR = new int[length];
        maxL[0] = height[0];
        for (int i = 1; i < length; i++) {
            // Caution 2 i - 1 
            maxL[i] = Math.max(maxL[i - 1], height[i]);
        }
        // Caution 3 length - 1
        maxR[length - 1] = height[length - 1];
        // Caution 4 length - 2
        for (int i = length - 2; i >= 0; i--) {
            maxR[i] = Math.max(maxR[i + 1], height[i]);
        }
        for (int i = 1; i < length - 1; i++) {
            result += Math.min(maxL[i], maxR[i]) - height[i];
        }
        return result;
    }
    /**
     * 解法4 栈的应用
     * 使用栈标记低谷和两界，
     *
     * @param columns
     * @return
     */
    public static int trap3(int[] columns) {
        int result = 0, cursor = 0, length = columns.length;
        Stack<Integer> stack = new Stack<Integer>();
        while (cursor < length) {
            if (stack.isEmpty() || columns[cursor] < columns[stack.peek()]) {
                stack.push(cursor++);
            } else {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    continue;
                }
                int left = stack.peek();
                int square = (Math.min(columns[left], columns[cursor]) - columns[bottom]) * (cursor - left - 1);
                result += square;
            }
        }
        return result;
    }

    /**
     * 解法3 DP求解 单次遍历<p>
     * 看题解，提取主干思路：<p>
     *   双指针替换两次遍历<p>
     * 自己学习 思考 实践时的难点(难点是如何突破的见wiki)：<p>
     *   虽然用dp存储了一些计算结果，但还是和暴力一样遍历了两次，如何减少循环次数？<p>
     *
     * @param height
     * @return 
     */
    public int trap4(int[] height) {
        int result = 0, left = 0, right = height.length - 1;
        int maxl = 0, maxr = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxl) {
                    maxl = height[left];
                } else {
                    result += (maxl - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= maxr) {
                    maxr = height[right];
                } else {
                    result += (maxr - height[right]);
                }
                --right;
            }
        }
        return result;
    }

     /**
     * 解法4 栈的应用
     * 使用栈标记低谷和两界，
     *
     * @param height
     * @return
     */
    public int trap5(int[] height) {
        int water = 0;
        if (height.length == 0) return water;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
                maxL = Math.max(maxL, height[l]);
                water += maxL - height[l];
            }
            else {
                r--;
                maxR = Math.max(maxR, height[r]);
                water += maxR - height[r];
            }
        }
        return water;
    }
 

}
