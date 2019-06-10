package highFrequencyLeetcode.leetcode_88;

/**
 *
 * <p>
 *  给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 *  说明:
 *
 *
 *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *  你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *
 *
 *  示例:
 *
 *  输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * </p>
 * @author Seina
 * @version 2019-06-10 08:30:06
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n < 1) {
            return;
        }
        /**
         * n > 0: 表示 nums2 中还有元素未装入 nums1，装满则退出循环
         * m > 0: 表示 nums1 中的 m 个元素还没有全部比较完，比较完也退出循环
         *
         * 从后往前遍历，每次比较都将大的那个元素逐个放在 nums1 的后面
         */
        for (int i = m + n - 1; (m > 0 && n > 0); i--) {
            if (nums1[m-1] > nums2[n-1]) {//nums1 的元素大于 nums2 的元素，就将 nums1 的元素取出来放后面
                nums1[i] = nums1[m-1];
                m--;
            } else {//nums1 的元素小于等于 nums2 的元素，就将 nums2 的元素取出来放后面
                nums1[i] = nums2[n-1];
                n--;
            }
        }

        /**
         * m = 0: 表示 nums1 中的 m 个元素全部比较完，但是 nums2 的 n 个元素还没有全部装入到 nums1 中，就需要把剩余排好序的元素直接放入到 nums1 的前面
         */
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}

























