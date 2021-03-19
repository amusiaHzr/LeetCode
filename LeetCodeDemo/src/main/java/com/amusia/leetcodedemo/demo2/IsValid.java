package com.amusia.leetcodedemo.demo2;

import com.amusia.leetcodedemo.PrintResult;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "([)]"
 * 输出：false
 * 示例 5：
 * <p>
 * 输入：s = "{[]}"
 * 输出：true
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "()(){}{}[][]{}(){{";
//        String s = "(((({{[{([({[]})]}]}}))))";
        boolean result = isValid(s);
        PrintResult.print(result);
    }

    /****第一次练习 2021-3-19****/

    /**
     * 暴力求解法
     * replace所有的括号，并替换成""，比较最后的字符串是否为""即可
     *
     * @param s
     * @return
     */
//    private static boolean isValid(String s) {
//        while (s.contains("()")|| s.contains("[]")||s.contains("{}")){
//            s = s.replace("()", "");
//            s = s.replace("[]", "");
//            s = s.replace("{}", "");
//        }
//        return "".equals(s);
//    }

    /**
     * 使用stack求有效括号
     *
     * @param s
     * @return
     */
    private static boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp == '(') {
                stack.push(')');
            } else if (temp == '[') {
                stack.push(']');
            }
            if (temp == '{') {
                stack.push('}');
            }
            Character peek = stack.peek();
            if (temp == peek) {
                stack.pop();
            }
        }
        return stack.empty();
    }
}
