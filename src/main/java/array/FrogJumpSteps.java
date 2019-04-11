package array;

/**
 * @author Seina
 * @version 2019-04-09 17:15:25
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
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
