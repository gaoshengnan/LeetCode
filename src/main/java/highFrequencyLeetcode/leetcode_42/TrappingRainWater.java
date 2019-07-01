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
 * @version 2019/6/3 20:18
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
     * 解法3 栈的应用
     * 使用栈标记低谷和两界
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
     * 解法4 双指针
     * 
     * 两个指针分别从左开始、从右开始向中间走，每次移动较小节点，并更新左边最大和右边最大，再累加可接雨水
     * 
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * 
     * @param height: 宽度为 1 的柱子高度
     * @return 能接多少雨水
     * @author Seina
     */
    public int trap5(int[] height) {
        int water = 0;
        if (height.length == 0) return water;
        int l = 0, r = height.length - 1;
        int maxL = height[l], maxR = height[r];
        while (l < r) {
            if (height[l] <= height[r]) {
                l++;
                //更新当前元素左边最大
                maxL = Math.max(maxL, height[l]);
                //当 l < r 时，l 向右移动，如果移动之后的元素很大，比 maxR 还大，也不用担心，因为此时 maxL = height[l]，相减等于零，不会接任何水
                //当然如果没有比 maxR 大，就相当于取了 maxL 和 maxR 中较小的一个，减去 height[l]，得到当前元素上可以接多少水
                water += maxL - height[l];
            }
            else {
                r--;
                //更新当前元素右边最大
                maxR = Math.max(maxR, height[r]);
                water += maxR - height[r];
            }
        }
        return water;
    }
}
