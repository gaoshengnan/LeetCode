package leetcode.stack.validParentheses;

/**
 * @author Seina
 * @version 2019-01-25 20:58:04
 *
 * LeetCode20：有效的括号
 */
public class ValidParentheses {
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
