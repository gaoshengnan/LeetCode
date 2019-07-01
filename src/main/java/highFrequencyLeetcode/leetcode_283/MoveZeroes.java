package highFrequencyLeetcode.leetcode_283;

/**
 * <p>
 *
 *  给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 *  示例:
 *
 *  输入: [0,1,0,3,12]
 *  输出: [1,3,12,0,0]
 *
 *  说明:
 *
 *
 *  必须在原数组上操作，不能拷贝额外的数组。
 *  尽量减少操作次数。
 *
 * </p>
 * 
 * @author Seina
 * @version 2019-06-11 21:13:59
 */
public class MoveZeroes {

    /**
     * 解法1
     *
     * @param nums: 数组
     */
    public void moveZeroes (int[] nums) {
        int i = 0; 
        for (int j = 0; j < nums.length; j++) {
            //将不等于 0 的元素往前移动，并同时移动 i 指针
            if (nums[j] != 0) {
                nums[i] = nums[j];
                i++;
            }
        }
        //i 之前的元素移动好的【不为 0 的元素】
        //p 指针从 i 开始，将 i 后面的元素都变成 0 
        for (int p = i; p < nums.length; p++) {
            nums[p] = 0;
        }
    }
}
