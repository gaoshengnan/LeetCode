package leetcode.array.leetcode_70;

/**
 *
 * <p>
 *
 *  假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 *  每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 *  注意：给定 n 是一个正整数。
 *
 *  示例 1：
 *
 *  输入： 2
 *  输出： 2
 *  解释： 有两种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶
 *  2.  2 阶
 *
 *  示例 2：
 *
 *  输入： 3
 *  输出： 3
 *  解释： 有三种方法可以爬到楼顶。
 *  1.  1 阶 + 1 阶 + 1 阶
 *  2.  1 阶 + 2 阶
 *  3.  2 阶 + 1 阶
 *
 * </p>
 *
 * @author Seina
 * @version 2019-04-09 17:15:25
 *
 */
public class FrogJumpSteps {

    /**
     * 非递归实现
     * @param target: 台阶数
     * @return 多少种跳法
     */
    public int jump(int target){
        int result = 0;
        int num1 = 1;
        int num2 = 1;
        if (target <= 1) return 1;
        for (int i = 1; i < target; i++) {
            result = num1 + num2;
            num1 = num2;
            num2 = result;
        }
        return result;
    }

    /**
     * 递归实现
     * @param target: 台阶数
     * @return 多少种跳法
     */
    public int recursionJump(int target){//递归实现
        if (target <= 0) return 0;
        int[] str = {0, 1, 2};
        if (target < 3) return str[target];
        return recursionJump(target - 1) + recursionJump(target - 2);
    }
}
