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


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ValidParentheses {
    public static void main(String[] args) {

        Solution solution = new ValidParentheses().new Solution();
        System.out.println(solution.isValid("{{"));
        System.out.println(solution.isValid2("}{{{}{[]}}[][]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            HashMap<Character, Character> dir = new HashMap<>();
            dir.put('{', '}');
            dir.put('(', ')');
            dir.put('[', ']');
            if (s.length() % 2 == 1) {
                return false;
            }
            Deque<Character> stack = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (dir.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || !dir.get(stack.peek()).equals(c)) {
                        return false;
                    } else {
                        stack.poll();
                    }
                }
            }
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (dir.containsKey(c)) {
                    stack.push(c);
                }
                if (stack.isEmpty()) {
                    System.out.println(c + "未找到对应开口");
                    return false;
                }
                if (dir.containsValue(c)) {
                    if (dir.get(stack.peek()).equals(c)) {
                        stack.poll();
                    } else {
                        System.out.println(stack.peek() + "不匹配" + c);
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }

        public boolean isValid2(String s) {
            int n = s.length();
            if (n % 2 == 1) {
                return false;
            }

            Map<Character, Character> pairs = new HashMap<Character, Character>() {{
                put(')', '(');
                put(']', '[');
                put('}', '{');
            }};
            Deque<Character> stack = new LinkedList<Character>();
            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);
                if (pairs.containsKey(ch)) {
                    if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                        return false;
                    }
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            return stack.isEmpty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
