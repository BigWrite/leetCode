package com.mars.leetCode.editor.cn;
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串

import org.junit.platform.commons.util.StringUtils;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class ValidParentheses{
    public static void main(String[] args){

        Solution solution = new ValidParentheses().new Solution();
        solution.isValid("{}{}[][]");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> dir = new HashMap<>();
        dir.put('{','}');
        dir.put('(',')');
        dir.put('[',']');
        boolean flag = true;
        if (StringUtils.isBlank(s)||s.length()%2!=0) {
            System.out.println("输入字符串不能为空，且长度应为2的倍数");
            return !flag;
        }
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!dir.containsKey(c)) {
                System.out.println("包含非法字符或字符不匹配");
                return !flag;
            }
            stack.push(c);
            i++;
        }
        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
