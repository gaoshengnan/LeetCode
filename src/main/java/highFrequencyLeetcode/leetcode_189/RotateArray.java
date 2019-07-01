package highFrequencyLeetcode.leetcode_189;


/**
 * <p>
 *
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 *
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 *
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-09 23:49:37
 */
public class RotateArray {

    /**
     * 解法1
     *
     * 时间复杂度：O(kn)
     * 空间复杂度：O(1)
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++){
            int temp = nums[n - 1];//将最后一个元素暂存起来
            for (int j = n - 1; j > 0; j--){
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;//将暂存的元素复制给 nums[0]
        }
    }

    /**
     * 解法2
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public void rotate2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        //先整体翻转，再局部排序
        reverse(nums, 0, n - 1);//[7, 6, 5, 4, 3, 2, 1]
        reverse(nums, 0, k - 1);//[5, 6, 7, 4, 3, 2, 1]
        reverse(nums, k, n - 1);      //[5, 6, 7, 1, 2, 3, 4]

    }
    private void reverse(int[] nums, int start, int end){
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}































