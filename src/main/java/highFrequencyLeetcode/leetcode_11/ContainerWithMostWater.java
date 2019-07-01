package highFrequencyLeetcode.leetcode_11;

/**
 * <p>
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 具体图片请查看 leetcode
 *
 * 示例:
 *
 *  输入: [1,8,6,2,5,4,8,3,7]
 *  输出: 49
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-13 22:05:17
 */
public class ContainerWithMostWater {

    /**
     * 暴力法
     *
     * 时间复杂度：O(n²)
     * 空间复杂度：O(1)
     * 
     * @param height：线段高度
     * @return 矩形最大面积
     */
    public int maxArea1(int[] height) {
        int maxarea = 0;
        for (int i = 0; i < height.length; i++) 
            for (int j = i + 1; j < height.length; j++) 
                //取两条边最小的 * 下标差，就是矩形区域面积
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
            return maxarea;
    }

    /**
     * 双指针法
     *
     * 矩形面积主要取决于两线段的距离（长）和两线段中最短的那条长度（宽）来决定的
     * 因为矩形要最大化，两条线段的距离越远越好，两条线段的最短长度也要越长越好
     * 所以不停缩短距离，不停越过较短的线段来移动指针，并同时更新 maxarea
     *
     * 时间复杂度：O(n) 一次扫描
     * 空间复杂度：O(1)
     *
     * @param height：线段高度
     * @return 矩形最大面积
     */
    public int maxArea2(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) 
                l++;
            else
                r--;
            
        }
        return maxArea;
    }
}
