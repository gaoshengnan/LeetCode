package highFrequencyLeetcode.leetcode_78;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *
 *  给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 *  说明：解集不能包含重复的子集。
 *
 *  示例:
 *
 *  输入: nums = [1,2,3]
 *  输出:
 *  [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 *  ]
 *
 * </p>
 *
 * @author Seina
 * @version 2019-06-26 20:31:22
 */
public class Subsets {

    /**
     * 解法1 递归
     *
     * @param nums: 不含重复元素的整数数组
     * @return 所有子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        getAns(nums, 0, new ArrayList<Integer>(), ans);
        return ans;
    }

    /**
     *
     * 递归填充结果集合 ans
     *
     * ans 和 temp 的树形变化 ：           [1]      [2]     [3]
     *                                 /    \     |
     *                              [12]  [13]  [23]
     *                               /
     *                           [123]
     *
     *
     * temp 的增长变化 ：     a: [1]       e: [2]    g: [3]
     *                       /    \        |
     *                 b: [2]   d: [3]   f: [3]
     *                   /
     *              c: [3]
     *
     * 举例说明：
     *
     * 比如 a -> b -> c 开始递归调用到 c: [3]，它的下一层递归将 [123] 存进去就结束了
     *
     * 然后当前所在层的递归也就结束了，就开始执行 temp.remove，移掉 [3]
     *
     * 然后递归 b: [2] 陆续结束，开始移掉 [2]，然后循环控制继续走递归 a: [1]   的另一部分，递归调用 d: [3]
     *
     * 以此类推，简单变化过程如下图：
     *
     *
     *     a: [1]          a: [1]         a: [1]           a: [1]             a: [1]
     *             ->        /      ->       /      ->       /       ->           \
     *                  b: [2]           b: [2]          b: [2]                 d: [3]
     *                                    /
     *                                 c: [3]
     *
     * @param nums: 题目给定数组
     * @param start: 开始指针
     * @param temp: 可以理解成结果集合里面的子集
     * @param ans: 结果集合
     */
    private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
        //将子集添加到结果集合中
        ans.add(new ArrayList<Integer>(temp));

        for (int i = start; i < nums.length; i++) {

            temp.add(nums[i]);
            //从 start + 1 开始，递归下坠到后面的元素
            getAns(nums, i + 1, temp, ans);

            //每次递归调用结束将加入到 temp 的元素删除
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 解法2 位运算解决
     *
     * @param nums: 不含重复元素的整数数组
     * @return 所有子集
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j ++)
                if (( (i >> j) & 1 ) == 1) sub.add(nums[j]);
            ans.add(sub);
        }
        return ans;
    }
}
