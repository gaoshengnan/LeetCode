package highFrequencyLeetcode.leetcode_20;

/**
 * <p>
 *  给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 *  有效字符串需满足：
 *
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 *
 *  注意空字符串可被认为是有效字符串。
 *
 *  示例 1:
 *  输入: "()"
 *  输出: true
 *
 *  示例 2:
 *  输入: "()[]{}"
 *  输出: true
 *
 *  示例 3:
 *  输入: "(]"
 *  输出: false
 *
 *  示例 4:
 *  输入: "([)]"
 *  输出: false
 *
 *  示例 5:
 *  输入: "{[]}"
 *  输出: true
 *
 * </p>
 *
 * @author Seina
 * @version 2019-01-25 20:58:04
 *
 */
public class ValidParentheses {

    /**
     * 解法1
     *
     * @param s：给定一个字符串
     * @return 返回是否有效 true or false
     */
    public static boolean isValid(String s) {
        if(s == null || s.length() == 1) return false;
        if(s.length() == 0) return true;

        //toCharArray声明了一个字符串长度那么大的数组arr
        char[] arr = s.toCharArray();
        if (arr[0] == ')' || arr[0] == ']' || arr[0] == '}') return false;

        //又声明了一个比字符串长度大1的数组stack（可以理解成底层是数组实现的顺序栈）
        int[] stack = new int[arr.length+1];
        int ptr = 0;

        //开始遍历数组arr
        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            switch(arr[i]){
                case '(':val = -1;break;
                case ')':val = 1;break;
                case '[':val = -2;break;
                case ']':val = 2;break;
                case '{':val = -3;break;
                case '}':val = 3;break;
                default:break;
            }
            if(stack[ptr] + val == 0){
                stack[ptr--] = 0;
            }else{
                stack[++ptr] = val;
            }
        }
        return stack[1] == 0;
    }

}
