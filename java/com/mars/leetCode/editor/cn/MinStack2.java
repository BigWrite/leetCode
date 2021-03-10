package com.mars.leetCode.editor.cn;
//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计

public class MinStack2 {
    public static void main(String[] args) {
        Solution solution = new MinStack2().new Solution();
        solution.push(-2);
        solution.push(0);
        solution.push(-3);
        System.out.println(solution.getMin());
        solution.pop();
        System.out.println(solution.top());
        System.out.println(solution.getMin());

    }
//leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        class Node<N> {

            private Node<N> pre;
            private Node<N> next;
            N item;

            public Node(Node<N> pre, Node<N> next, N item) {
                this.pre = pre;
                this.next = next;
                this.item = item;
            }
        }

        /**
         * initialize your data structure here.
         */
        private Node<Integer> first;
        private Node<Integer> last;
        private Node<Integer> min;

        public Solution() {

        }


        public void push(int x) {
            if (first == null) {
                first = new Node<>(null, null, x);
                last = new Node<>(null, null, x);
                min = new Node<>(null, null, x);
            } else {
                Node<Integer> node = new Node<>(null, first, x);
                first.pre = node;
                first = node;

                Node<Integer> min ;
                if (this.min.item > x) {
                    min = new Node<>(null, this.min, x);
                    this.min.pre = min;
                    this.min = min;
                }else {
                    min = new Node<>(null, this.min, this.min.item);
                    this.min.pre = min;
                    this.min = min;
                }

            }


        }

        public void pop() {
            if (first == null) {
                throw new IllegalArgumentException("the stack is empty");
            }
            first = first.next;
            min = min.next;
            if (first == null) {
                this.last = null;
            } else {
                first.pre = null;
            }
        }

        public int top() {
            int node = first.item;
            return node;
        }

        public int getMin() {
            return min.item;
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}
